package com.pyramid.rpc.crawler.threads;

import java.util.Set;

import com.pyramid.rpc.crawler.htmlparsers.HtmlParserTool;
import com.pyramid.rpc.crawler.queues.LinkQueue;
import com.pyramid.rpc.crawler.utils.URLUtil;

/**
 * 
 * @author leiming4
 *
 */
public class UnvisitedURLThread extends Thread {

	private LinkQueue lq;

	public UnvisitedURLThread() {

	}

	public UnvisitedURLThread(LinkQueue lq) {
		this.lq = lq;
	}

	@Override
	public void run() {

		System.out.println("--->>>  UnvisitedURLThread --->>> ");
		int unVisitedUrlCount = lq.getUnvisitedUrlNum();

		for (int i = 0; i < unVisitedUrlCount; i++) {

			String unVisitUrl = (String) lq.unVisitedUrlDeQueue();
			boolean bool = URLUtil.getInstance().exists(unVisitUrl);
			System.out.println("--->>> url exists: " + bool + ", unVisitUrl: " + unVisitUrl);

			if (bool == true) {

				// 存储可访问的URL
				lq.addVisitedUrl(unVisitUrl);

				// 解析页面，获取新的URL种子
				Set<String> links = HtmlParserTool.extracLinks(unVisitUrl, URLUtil.getInstance().getLinkFilter());
				for (String link : links) {

					bool = URLUtil.getInstance().exists(link);
					System.out.println("--->>> url exists: " + bool + ", unVisitUrl: " + link);

					if (bool == true) {
						System.out.println("--->>> downloading: " + link);
						lq.addUnvisitedUrl(link);
					}
				}

				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					System.out.println("--->>> Exception: extract links - " + e.getMessage());
				}
			}
		}
		System.out.println("");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
