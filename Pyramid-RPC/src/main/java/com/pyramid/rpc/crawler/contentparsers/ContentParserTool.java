package com.pyramid.rpc.crawler.contentparsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pyramid.rpc.crawler.contentparsers.entity.Content;

public class ContentParserTool implements ContentParser {

	private Logger log = Logger.getLogger(getClass());

	/**
	 * 
	 */
	public ContentParserTool() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 解析多个URL
	 * 
	 * @param urls
	 * @return
	 */
	public List<Content> parserUrls(Set<String> urls) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		for (String url : urls) {
			Content content = parserUrl(url);
			list.add(content);
		}
		return list;
	}

	/**
	 * 测试页面Baidu首页
	 * 
	 * @param url
	 */
	public void test01(String url) {
		// TODO Auto-generated method stub
		try {
			Document document = Jsoup.connect(url).get();
			String cssQuery = "html body div div div p#nv a";
			log.debug("total cssQuery: " + cssQuery);
			Iterator it = document.select(cssQuery).iterator();
			String result = "Result: ";
			while (it.hasNext()) {
				result += ((Element) it.next()).text() + ", ";
			}
			log.info("Result: " + result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 测试CSDN article页面
	 * 
	 * @param url
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.java.crawler02.contentparsers.ContentParser#parser(java.lang.String
	 * )
	 */
	@Override
	public Content parserUrl(String url) {
		Content content = new Content();
		try {
			if (url != null && !"".equals(url.trim())) {
				System.out.println("Url: " + url);

				Document document = Jsoup.connect(url).get();
				String body = "html body ";
				// title
				String titleCSS = body + "div div div div h1";
				Element element_title = document.select(titleCSS).first();
				String title = element_title.text();
				System.out.println("Title: " + title);
				content.setTitle(title);

				// publicDate; // 发布时间
				// String publicDateCSS = body +
				// "div div div div h4 div span.ago";
				String publicDateCSS = "div span.ago";
				Element element_publicDate = document.select(publicDateCSS)
						.first();
				String publicDate = element_publicDate.text();
				System.out.println("Public Date: " + publicDate);
				content.setPublicDate(publicDate);

				// visitedCount; // 访问次数
				// String visitedCountCSS = body
				// + "div div div div h4 div span.view_time";
				String visitedCountCSS = "span.view_time";
				Element element_visitedCount = document.select(visitedCountCSS)
						.first();
				String visitedCount = element_visitedCount.text();
				System.out.println("Visited Count: " + visitedCount);
				content.setVisitedCount(visitedCount);

				// source; // 来源
				// String sourceCSS = body + "div div div div h4 div span.ago";
				String sourceCSS = "div span.age";
				Elements elements_source = document.select(sourceCSS);
				String source = "无";
				if (elements_source != null) {
					Object[] object_sources = elements_source.toArray();
					if (object_sources.length != 0) {
						Element element_source = (Element) object_sources[1];
						source = element_source.text();
						System.out.println("Source: " + source);
					} else {
						System.out.println("Source: 无");
					}
				} else {
					System.out.println("Source: 无");
				}
				content.setSource(source);

				// author; // 作者
				// String authorCSS = body + "div div div div h4 div span.ago";
				Elements elements_author = document.select(sourceCSS);
				String author = "无";
				if (elements_author != null) {
					Object[] object_author = elements_author.toArray();
					if (object_author.length != 0) {
						Element element_author = (Element) object_author[2];
						author = element_author.text();
						System.out.println("Author: " + author);
					} else {
						System.out.println("Author: 无");
					}
				} else {
					System.out.println("Author: 无");
				}
				content.setAuthor(author);

				// anchor; // 特征词
				// String anchorCSS = body + "div div div div div.tag a";
				String anchorCSS = "div div.tag a";
				String anchor = "无";
				Object[] object_anchors = document.select(anchorCSS).toArray();
				for (Object obj : object_anchors) {
					anchor += ((Element) obj).text() + ", ";
				}
				System.out.println("Anchor: " + anchor);
				content.setAnchor(anchor);

				// summary; // 摘要
				// String summaryCSS = body + "div div div div div.summary";
				String summaryCSS = "div.summary";
				String summary = "无";
				Elements elements_summary = document.select(summaryCSS);
				if (elements_summary != null) {
					Object[] objects_summary = elements_summary.toArray();
					if (objects_summary.length != 0) {
						for (Object object_summary : objects_summary) {
							Element element_summary = (Element) object_summary;
							summary += element_summary.text() + "|";
							System.out.println("Summary: " + summary);
						}
					} else {
						System.out.println("Summary: 无");
					}
				} else {
					System.out.println("Summary: 无");
				}
				content.setSummary(summary);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	public static ContentParserTool contentParserTool;

	public static ContentParserTool getInstance() {
		if (contentParserTool == null) {
			contentParserTool = new ContentParserTool();
		}
		return contentParserTool;
	}

	public static void main(String[] args) {

		String url = null;

		ContentParserTool tool = ContentParserTool.getInstance();
		// // 1.测试
		// url = "http://www.baidu.com";
		// tool.test01(url);

		// 2.测试
		url = "http://www.csdn.net/article/2013-10-31/2817355-tablet-share";
		// url =
		// "http://www.csdn.net/article/tag/%E6%8E%A8%E8%8D%90%E7%B3%BB%E7%BB%9F";
		tool.parserUrl(url);

	}

}
