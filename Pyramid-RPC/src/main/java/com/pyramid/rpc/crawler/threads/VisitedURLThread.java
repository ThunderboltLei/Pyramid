package com.pyramid.rpc.crawler.threads;

import java.io.File;

import com.pyramid.rpc.crawler.download.DownloadFile;
import com.pyramid.rpc.crawler.queues.LinkQueue;

/**
 * 
 * @author leiming4
 *
 */
public class VisitedURLThread extends Thread {

	private LinkQueue lq;
	private String visitUrl;

	public VisitedURLThread() {

	}

	public VisitedURLThread(LinkQueue lq) {
		this.lq = lq;
	}

	public VisitedURLThread(LinkQueue lq, String visitUrl) {
		this.lq = lq;
		this.visitUrl = visitUrl;
	}

	@Override
	public void run() {
		System.out.println("<<<--- VisitedURLThread !!!!!");
		// Iterator<?> it = lq.getVisitedUrl().iterator();
		// System.out.println("size: " + lq.getUnVisitedUrl().size());
		// while (it.hasNext()) {
		for (String visitUrl : lq.getVisitedUrl()) {
			// String visitUrl = (String) it.next();
			System.out.println("<<<--- visitUrl: " + visitUrl);
			lq.removeVisitedUrl(visitUrl);
			DownloadFile downLoader = new DownloadFile();
			String strPageFile = downLoader.downloadFile(visitUrl);
			File pageFile = new File(strPageFile);
			if (pageFile.exists()) {
				System.out.println("<<<--- Has downloaded: " + visitUrl);
			} else {
				System.out.println("<<<--- pageFile: " + pageFile.getPath());
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
