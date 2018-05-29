package com.pyramid.rpc.crawler.queues;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author leiming4
 *
 */
public class LinkQueue {

	// 已访问的URL集合
	// private static Set<String> visitedUrl = new HashSet<String>();
	private static List<String> visitedUrl = new CopyOnWriteArrayList<String>();

	// 待访问的URL集合
	// private static PriorityQueue unVisitedUrl = new PriorityQueue();
	private static LinkedBlockingQueue<String> unVisitedUrl = new LinkedBlockingQueue<String>();

	public synchronized List<String> getVisitedUrl() {
		return visitedUrl;
	}

	/**
	 * 获得 URL队列
	 * 
	 * @return
	 */
	// public static PriorityBlockingQueue<String> getUnVisitedUrl() {
	public synchronized LinkedBlockingQueue<String> getUnVisitedUrl() {
		return unVisitedUrl;
	}

	/**
	 * 已访问的URL：添加到访问过的URL队列中
	 * 
	 * @param url
	 */
	public synchronized void addVisitedUrl(String url) {
		visitedUrl.add(url);
		// System.out.println("@@@ --- visitedUrl: notifyAll");
		notifyAll();
	}

	/**
	 * 已访问的URL：移除访问过的URL
	 * 
	 * @param url
	 */
	public synchronized void removeVisitedUrl(String url) {
		while (visitedUrlsEmpty() == true) {
			try {
				// System.out.println("@@@ --- visitedUrl: wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// if (visitedUrlsEmpty() != true) {
		visitedUrl.remove(url);
		// }
	}

	/**
	 * 未访问的URL队列：未访问的URL出队列
	 * 
	 * @return
	 */
	public synchronized Object unVisitedUrlDeQueue() {
		while (unVisitedUrlsEmpty() == true) {
			try {
				// System.out.println("!!! --- unVisitedUrl: wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// if (unVisitedUrlsEmpty() == true) {
		// return null;
		// }
		return unVisitedUrl.poll();
	}

	/**
	 * 未访问的URL队列：保证每个URL只被访问一次
	 * 
	 * @param url
	 */
	public synchronized void addUnvisitedUrl(String url) {
		boolean bool = url != null && !url.trim().equals("") && !visitedUrl.contains(url)
				&& !unVisitedUrl.contains(url);
		if (bool == true) {
			unVisitedUrl.add(url);
			// System.out.println("!!! --- unVisitedUrl: nofityAll");
			notifyAll();
		}
	}

	public boolean visitedUrlsEmpty() {
		return visitedUrl.isEmpty();
	}

	/**
	 * 获得已经访问的URL数目
	 * 
	 * @return
	 */
	public int getVisitedUrlNum() {
		return visitedUrl.size();
	}

	/**
	 * 判断未访问的URL队列中是否为空
	 * 
	 * @return
	 */
	public boolean unVisitedUrlsEmpty() {
		return unVisitedUrl.isEmpty();
	}

	/**
	 * 获取未访问的URL数目
	 * 
	 * @return
	 */
	public int getUnvisitedUrlNum() {
		return unVisitedUrl.size();
	}

	public static LinkQueue linkQueue;

	public static LinkQueue getInstance() {
		if (linkQueue == null) {
			linkQueue = new LinkQueue();
		}
		return linkQueue;
	}

	public static void main(String[] args) {

		String url = "https://mall.jd.com/\"//item.jd.com/4633035.html";
		System.out.println("first index: " + url.indexOf("//") + ", last index: " + url.lastIndexOf("//"));
		System.out.println(url.substring(6, 21));
		System.out.println(url.replace(url.substring(6, 21), ""));
		System.exit(0);

		LinkQueue lq = LinkQueue.getInstance();
		lq.addUnvisitedUrl("a");
		lq.addUnvisitedUrl("a");
		lq.addUnvisitedUrl("a");

		if (lq.getUnVisitedUrl().contains("a")) {
			System.out.println("include");
		} else {
			System.out.println("exclude");
		}
	}
}
