package com.pyramid.rpc.crawler.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author leiming4
 * 
 * @description 创建线程池处理未访问的URL<br>
 *
 */
public class ThreadPoolDoor {

	private ExecutorService executorServiceDownload = null;
	private ExecutorService executorServiceExtract = null;

	private final static int THREAD_POOL_DOWNLOAD = 200;
	private final static int THREAD_POOL_EXTRACT = 100;

	/**
	 * constructer with no parameter
	 */
	public ThreadPoolDoor() {
		// int THREAD_COUNT = Integer.parseInt(PropertiesUtil.getInstance()
		// .readValue("THREAD_COUNT").trim());
		this.executorServiceDownload = Executors.newFixedThreadPool(THREAD_POOL_DOWNLOAD);
		this.executorServiceExtract = Executors.newFixedThreadPool(THREAD_POOL_EXTRACT);
	}

	public static ThreadPoolDoor threadPoolDoor = null;

	public static ThreadPoolDoor getInstance() {
		if (threadPoolDoor == null) {
			threadPoolDoor = new ThreadPoolDoor();
		}
		return threadPoolDoor;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ExecutorService getExecutorServiceDownload() {
		return executorServiceDownload;
	}

	public void setExecutorServiceDownload(ExecutorService executorServiceDownload) {
		this.executorServiceDownload = executorServiceDownload;
	}

	public ExecutorService getExecutorServiceExtract() {
		return executorServiceExtract;
	}

	public void setExecutorServiceExtract(ExecutorService executorServiceExtract) {
		this.executorServiceExtract = executorServiceExtract;
	}

}
