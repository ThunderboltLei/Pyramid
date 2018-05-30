package com.pyramid.rpc.crawler.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pyramid.rpc.crawler.filters.LinkFilter;

public class URLUtil {

	/**
	 * 正则验证URL是不是同一个网站
	 */
	private LinkFilter linkFilter = new LinkFilter() {
		@Override
		public boolean accept(String url) {
			return regexStart(url);
		}
	};

	/**
	 * 通过正则验证是否是符合条件的URL
	 * 
	 * @param url
	 * @return
	 */
	public boolean regexStart(String url) {
		boolean bool = false;
		String strRegex = null;
		if (url.toLowerCase().contains("csdn")) {
			strRegex = "^(http|https|ftp|)?(://)([a-z0-9]*\\.)*" + Constant.CSDN
					+ "\\.net/article(/([\\s\\S]))*(\\.?(\\w\\W)*)(\\?)?(((\\w\\W*%)*(\\w\\W*\\?)*(\\w\\W*:)*(\\w\\W*\\+)*(\\w\\W*\\.)*(\\w\\W*&)*(\\w\\W*-)*(\\w\\W*=)*(\\w\\W*%)*(\\w\\W*\\?)*(\\w\\W*:)*(\\w\\W*\\+)*(\\w\\W*\\.)*(\\w\\W*&)*(\\w\\W*-)*(\\w\\W*=)*)*(\\w\\W*)*)$";

		} else if (url.toLowerCase().contains("jd")) {
			strRegex = "^(http:|https:|ftp:|)*(//)([a-z0-9]*\\.)*" + Constant.JD + "\\.com/(/([\\s\\S]))*";
		}
		//// 原始
		// String strRegex = "^(http|https|ftp|)?(://)([a-z0-9]*\\.)*" + Constant.CSDN
		// +
		// "\\.net/article(/([\\s\\S]))*(\\.?(\\w\\W)*)(\\?)?(((\\w\\W*%)*(\\w\\W*\\?)*(\\w\\W*:)*(\\w\\W*\\+)*(\\w\\W*\\.)*(\\w\\W*&)*(\\w\\W*-)*(\\w\\W*=)*(\\w\\W*%)*(\\w\\W*\\?)*(\\w\\W*:)*(\\w\\W*\\+)*(\\w\\W*\\.)*(\\w\\W*&)*(\\w\\W*-)*(\\w\\W*=)*)*(\\w\\W*)*)$";
		//// JD
		// String strRegex = "^(http:|https:|ftp:|)*(//)([a-z0-9]*\\.)*" + Constant.JD +
		// "\\.com/(/([\\s\\S]))*";
		if (!url.trim().isEmpty()) {
			Pattern pattern = Pattern.compile(strRegex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(url);
			if (matcher.find()) {
				bool = true;
			} else {
				bool = false;
			}
		}
		return bool;
	}

	/**
	 * 判断url地址是否存在
	 * 
	 * @param url
	 * @return
	 */
	public boolean exists(String url) {
		try {
			// 设置此类是否应该自动执行 HTTP 重定向（响应代码为 3xx 的请求）。
			HttpURLConnection.setFollowRedirects(false);

			// 远程对象的连接
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

			// 设置 URL 请求的方法， GET POST HEAD OPTIONS PUT DELETE TRACE 以上方法之一是合法的，具体取决于协议的限制。
			con.setRequestMethod("HEAD");
			con.setConnectTimeout(3000);
			con.setUseCaches(false);

			// 从 HTTP 响应消息获取状态码
			// return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
			int respCode = con.getResponseCode();
			// System.out.println("respCode: " + respCode);
			if (respCode == HttpURLConnection.HTTP_OK || respCode == HttpURLConnection.HTTP_MOVED_PERM) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("~~~ Exception ~~~ " + e);
			return false;
		}
	}

	public static URLUtil urlUtil;

	public static URLUtil getInstance() {
		if (urlUtil == null) {
			urlUtil = new URLUtil();
		}
		return urlUtil;
	}

	/**
	 * @return the linkFilter
	 */
	public LinkFilter getLinkFilter() {
		return linkFilter;
	}

	public static void main(String[] args) {

		String[] urls = { "https://www.csdn.net/article/1970-01-01/278814", "http://www.csdn.net/article/" };
		for (String url : urls) {
			boolean bool = URLUtil.getInstance().exists(url);
			System.out.println("url exists: " + bool + ", url: " + url);
		}

	}

}
