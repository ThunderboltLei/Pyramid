package com.pyramid.rpc.crawler.htmlparsers;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import com.pyramid.rpc.crawler.filters.LinkFilter;
import com.pyramid.rpc.crawler.utils.URLUtil;

public class HtmlParserTool {

	// 获取一个网站上的链接，filter 用来过滤链接
	public static Set<String> extracLinks(String url, LinkFilter filter) {
		Set<String> links = new HashSet<String>();
		try {
			Parser parser = new Parser(url);
			parser.setEncoding("UTF-8");
			// 过滤<frame >标签的filter，用来提取frame 标签里的src 属性
			NodeFilter frameFilter = new NodeFilter() {

				private static final long serialVersionUID = -7676035766036922601L;

				public boolean accept(Node node) {
					if (node.getText().startsWith("frame src=")) { // csdn
						return true;
					} else {
						return false;
					}
				}
			};

			// OrFilter 来设置过滤<a> 标签和<frame> 标签
			OrFilter linkFilter = new OrFilter(new NodeClassFilter(LinkTag.class), frameFilter);
			// 得到所有经过过滤的标签
			NodeList list = parser.extractAllNodesThatMatch(linkFilter);
			for (int i = 0; i < list.size(); i++) {
				Node tag = list.elementAt(i);
				// <a> 标签
				if (tag instanceof LinkTag) {
					LinkTag link = (LinkTag) tag;
					String linkUrl = link.getLink();// URL
					// System.out.println("~~~ "+linkUrl);
					if (filter.accept(linkUrl)) {

						// Stratgy for JD
//						if (linkUrl.contains("jd.com")) {
							if (!linkUrl.contains("http") || !linkUrl.contains("https")) {
								links.add("https:" + linkUrl);
							} else {
								links.add(linkUrl);
							}
//						}
						// else {
						// links.add(linkUrl);
						// }
					}
				}
				// <frame> 标签
				else {
					// 提取frame 里src 属性的链接，如<frame src="test.html"/>
					String frame = tag.getText();
					int start = frame.indexOf("src=");
					frame = frame.substring(start);
					int end = frame.indexOf(" ");
					if (end == -1) {
						end = frame.indexOf(">");
					}
					String frameUrl = frame.substring(5, end - 1);
					if (filter.accept(frameUrl)) {
						links.add(frameUrl);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("--->>> Exception[extract link]: " + url + ", [information]: " + e.getMessage());
		}
		return links;
	}

	public static void main(String[] args) {

		LinkFilter filter = new LinkFilter() {
			public boolean accept(String url) {
				return URLUtil.getInstance().regexStart(url);
			}
		};

		Set<String> set = HtmlParserTool.extracLinks("https:http://item.jd.com/1588088687.html", filter);
		set.stream().forEach(url -> {
			System.out.println("url: " + url);
		});

	}
}
