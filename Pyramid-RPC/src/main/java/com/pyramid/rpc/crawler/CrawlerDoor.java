package com.pyramid.rpc.crawler;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pyramid.rpc.crawler.download.DownloadFile;
import com.pyramid.rpc.crawler.filters.LinkFilter;
import com.pyramid.rpc.crawler.htmlparsers.HtmlParserTool;
import com.pyramid.rpc.crawler.queues.LinkQueue;
import com.pyramid.rpc.crawler.threads.ThreadPoolDoor;
import com.pyramid.rpc.crawler.threads.UnvisitedURLThread;
import com.pyramid.rpc.crawler.threads.VisitedURLThread;
import com.pyramid.rpc.crawler.utils.URLUtil;

/**
 * @author leiming4
 *
 * @description: 正则验证，抓取指定网站下的URL<br>
 * 
 */
public class CrawlerDoor {

	private static final Logger LOG = LoggerFactory.getLogger(CrawlerDoor.class);

	private String domain = null;

	private ThreadPoolDoor threadPoolDoor = null;

	private LinkQueue linkQueue = null;

	private CopyOnWriteArrayList conwArrayList = new CopyOnWriteArrayList<>();
	
	public CrawlerDoor() {

		// 初始处理未访问URL的线程池
		threadPoolDoor = ThreadPoolDoor.getInstance();

		// 初始化存储
		linkQueue = LinkQueue.getInstance();
	}

	public CrawlerDoor(String domain) {

		// 设置要访问的域名
		this.domain = domain;
		System.out.println("domain: " + this.domain);

		// 初始处理未访问URL的线程池
		threadPoolDoor = ThreadPoolDoor.getInstance();

		// 初始化存储
		linkQueue = LinkQueue.getInstance();
	}

	/**
	 * 使用种子初始化URL队列
	 * 
	 * @return
	 * @param seeds
	 *            种子URL
	 */
	private void initCrawlerWithSeeds(String[] seeds) {
		for (int i = 0; i < seeds.length; i++) {
			linkQueue.addUnvisitedUrl(seeds[i]);
		}
	}

	/******************** version 2 **********************/
	/**
	 * 多线程处理未访问的URL
	 */
	public void dealUnvisitedUrls() {
		System.out.println("----- dealUnvisitedUrls -----");
		boolean bool = linkQueue.unVisitedUrlsEmpty();
		System.out.println("unVisitedUrlsEmpty: " + linkQueue.getUnvisitedUrlNum());
		if (!bool) {
			// new UnvisitedURLThread().run();
			// Thread t = new Thread(new UnvisitedURLThread());
			threadPoolDoor.getExecutorServiceExtract().execute(new UnvisitedURLThread(linkQueue));
		}
	}

	/**
	 * 多线程处理已访问的URL
	 */
	public void dealVisitedUrls() {
		System.out.println("----- dealVisitedUrls -----");
		boolean bool = linkQueue.visitedUrlsEmpty();
		System.out.println("visitedUrlsEmpty: " + linkQueue.getVisitedUrlNum());
		if (!bool) {
			// new VisitedURLThread().run();
			// Thread t = new Thread(new VisitedURLThread());
			// for (String visitUrl : linkQueue.getVisitedUrl()) {
			threadPoolDoor.getExecutorServiceDownload().execute(new VisitedURLThread(linkQueue));
			// }
		}
	}

	/**
	 * 多线程处理URL主函数
	 */
	public void poolDealUrls(String[] seeds) {

		/**
		 * To initialize the seeds<br>
		 */
		initCrawlerWithSeeds(seeds);

		/**
		 * To deal the unvisited urls and visited urls<br>
		 */
		while (true) {

			// // 未访问URL
			// dealUnvisitedUrls();
			//
			// // 已访问URL
			// dealVisitedUrls();

			// 未访问URL
			new Runnable() {

				@Override
				public void run() {
					dealUnvisitedUrls();
				}
			}.run();

			// 已访问URL
			new Runnable() {

				@Override
				public void run() {
					dealVisitedUrls();
				}

			}.run();
		}
	}

	/***************** version 1 ********************/
	/**
	 * 从未访问队列中出队头URL用递归方法解决得到的新URL
	 * 
	 * @param unvisitedUrl
	 */
	public void recusion(LinkQueue linkQueue) {
		System.out.println("unVisited URL Count: " + linkQueue.getUnvisitedUrlNum());
		/**
		 * 正则验证URL是不是同一个网站
		 */
		LinkFilter filter = new LinkFilter() {
			public boolean accept(String url) {
				return URLUtil.getInstance().regexStart(url);
			}
		};
		/**
		 * 初始化URL 队列
		 */
		String visitUrl = (String) linkQueue.unVisitedUrlDeQueue();
		/**
		 * 下载网页
		 */
		DownloadFile downLoader = new DownloadFile();
		String strPageFile = downLoader.downloadFile(visitUrl);
		File pageFile = new File(strPageFile);
		if (!pageFile.exists()) {
			System.out.println("Not download: " + visitUrl);
		} else {
			/**
			 * 将出队的URL放入已访问的URL中
			 */
			linkQueue.addVisitedUrl(visitUrl);
			/**
			 * 从已出队的URL网页中提取出可用的URL，并加入到未访问的队列中
			 */
			Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
			for (String link : links) {
				System.out.println(link);
				linkQueue.addUnvisitedUrl(link);
			}
		}
		recusion(linkQueue);
	}

	private Runnable runnable4Downloading(String url) {
		return new Runnable() {

			@Override
			public void run() {

				DownloadFile downLoader = new DownloadFile();
				String strPageFile = downLoader.downloadFile(url);
				File pageFile = new File(strPageFile);
				// System.out.println("\t>>> url: " + url + ", pageFile: " + pageFile);
				if (!pageFile.exists()) {
					System.out.println("--->>> downloading: " + url);
					linkQueue.addUnvisitedUrl(url);
				} else {
					// 3.将出队的URL放入已访问的URL中
					System.out.println("<<<--- updating: " + url);
					linkQueue.addVisitedUrl(url);
				}
			}
		};
	}

	private Runnable runnable4Extracting(String url, LinkFilter filter) {
		return new Runnable() {

			@Override
			public void run() {

				// 4.从已出队的URL网页中提取出可用的URL，并加入到未访问的队列中
				Set<String> links = HtmlParserTool.extracLinks(url, filter);
				for (String link : links) {

					boolean isInclude = linkQueue.getVisitedUrl().contains(link);
					if (!isInclude) {
						linkQueue.addUnvisitedUrl(link);

						if (link.contains("item.jd.com")) {
							System.out.println(
									"\tvisitUrl: " + link + ", unVisitedUrl: " + linkQueue.getUnvisitedUrlNum());
						} else if(link.contains("csdn.net")) {
							System.out.println(
									"\tvisitUrl: " + link + ", unVisitedUrl: " + linkQueue.getUnvisitedUrlNum());
						}

						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					}
				}
			}
		};
	}
	
	/**
	 * 多线程（线程池）抓取
	 * 
	 * @param seeds
	 *            URL种子
	 */
	public void crawlingByThreadPool(String[] seeds) {

		/**
		 * 正则验证URL是不是同一个网站
		 */
		LinkFilter filter = new LinkFilter() {
			
			@Override
			public boolean accept(String url) {
				return URLUtil.getInstance().regexStart(url);
			}
		};

		/**
		 * 初始化URL 队列
		 */
		initCrawlerWithSeeds(seeds);

		Thread t = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					while (linkQueue.getUnVisitedUrl().size() != 0) {
						// 队头URL出队列
						String visitUrl = (String) linkQueue.unVisitedUrlDeQueue();
						if (visitUrl == null) {
							System.out.println("    visitUrl is null, then next");
							continue;
						}

						// URL 清洗
						if (visitUrl.indexOf("https:") != -1 && visitUrl.indexOf("http:") != -1) {
							visitUrl = visitUrl.replace("http:", "");
						}
						if (visitUrl.indexOf("{") != -1 || visitUrl.indexOf("}") != -1) {
							continue;
						}
						int firstDoubleSlash = visitUrl.indexOf("//");
						int lastDoubleSlash = visitUrl.lastIndexOf("//");
						if (firstDoubleSlash != lastDoubleSlash) {
							visitUrl = visitUrl.replace(visitUrl.substring(firstDoubleSlash, lastDoubleSlash), "");
						}

						// To download
						if (visitUrl.contains("item.jd.com")) { // jd.com
							threadPoolDoor.getExecutorServiceDownload().execute(runnable4Downloading(visitUrl));
						} else if (visitUrl.contains("csdn")) { // csdn.net
							threadPoolDoor.getExecutorServiceDownload().execute(runnable4Downloading(visitUrl));
						}

						// To extract links
						threadPoolDoor.getExecutorServiceExtract().execute(runnable4Extracting(visitUrl, filter));
					}
				}
			}
		};
		t.start();
		
		conwArrayList.add(t.getId());

		LOG.info("The thread of crawler is starting ...");
	}

	/**
	 * 单线程抓取
	 * 
	 * @return
	 * @param seeds
	 *            URL种子
	 */
	public void crawling(String[] seeds) {
		/**
		 * 正则验证URL是不是同一个网站
		 */
		LinkFilter filter = new LinkFilter() {
			public boolean accept(String url) {
				return URLUtil.getInstance().regexStart(url);
			}
		};
		/**
		 * 初始化URL 队列
		 */
		initCrawlerWithSeeds(seeds);
		/**
		 * 循环条件：待抓取的链接不空且抓取的网页不多于1000
		 */
		// boolean bool = false;
		// System.out.println("bool = " + bool);

		while (true) {
			// 1.队头URL出队列
			String visitUrl = (String) linkQueue.unVisitedUrlDeQueue();
			if (visitUrl == null) {
				continue;
			}
			System.out.println("--->>> url: " + visitUrl);

			// 2.下载网页
			DownloadFile downLoader = new DownloadFile();
			String strPageFile = downLoader.downloadFile(visitUrl);
			File pageFile = new File(strPageFile);
			if (!pageFile.exists()) {
				System.out.println("Not download: " + visitUrl);
				linkQueue.addUnvisitedUrl(visitUrl);
			} else {
				// 3.将出队的URL放入已访问的URL中
				linkQueue.addVisitedUrl(visitUrl);
			}

			// 4.从已出队的URL网页中提取出可用的URL，并加入到未访问的队列中
			Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
			for (String link : links) {
				System.out.println("\tlink: " + link);
				linkQueue.addUnvisitedUrl(link);
			}

			// // 5.输出为未访问队列中的成员
			// for (int i = 0, n = LinkQueue.getUnvisitedUrlNum(); i < n; i++) {
			// System.out.println(LinkQueue.getUnVisitedUrl().toArray()[i]);
			// }
			// System.out.println("unvisited url's size = "
			// + LinkQueue.getUnvisitedUrlNum());
		}
	}
	
	/**
	 * 获取当前爬虫线程列表
	 * @return
	 */
	public List<String> getThreadList(){
		
		return null;
	}
	
	/**
	 * 取消某个或某些爬虫线程
	 */
	public void cancel() {
		
	}

	/**
	 * 爬虫主程序实例
	 */
	public static CrawlerDoor myCrawler;

	public static CrawlerDoor getInstance() {
		if (myCrawler == null) {
			myCrawler = new CrawlerDoor();
		}
		return myCrawler;
	}

	public static void main(String[] args) {

		CrawlerDoor crawler = CrawlerDoor.getInstance();

		String[] urls = new String[] { //
				 "https://www.csdn.net/article" //
//				"http://www.jd.com" //
//				"http://news.qq.com"
		};

		// To crawl the webpage specified by user
		// // Single Thread Crawler
		// crawler.crawling(urls);
		// // Multiply Threads Crawler
		crawler.crawlingByThreadPool(urls);

		// // version 1 - Recursive Crawler
		// LinkQueue.getInstance().addUnvisitedUrl("http://www.csdn.net/article/");
		// crawler.recusion(linkQueue);

		// version 2 - Multiply Threads Crawler
		// LinkQueue.getInstance().addUnvisitedUrl("http://www.csdn.net/article/");
		// crawler.poolDealUrls(urls);

		// // To regex the url
		// crawler.regexStart("http://e.baidu.com/?refer=888");
	}

	public CopyOnWriteArrayList getConwArrayList() {
		return conwArrayList;
	}

	public void setConwArrayList(CopyOnWriteArrayList conwArrayList) {
		this.conwArrayList = conwArrayList;
	}

}
