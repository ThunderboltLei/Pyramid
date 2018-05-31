package com.pyramid.rpc.crawler.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.pyramid.utils.cache.PropertyConfigurer;

/**
 * 
 * @author leiming4
 * 
 * @description 创建线程池处理未访问的URL<br>
 *
 */
@Scope("singleton")
public class ThreadPoolDoor {

	private static final Logger LOG = Logger.getLogger(ThreadPoolDoor.class);

	private ExecutorService executorServiceDownload = null;
	private ExecutorService executorServiceExtract = null;

	private int THREAD_POOL_DOWNLOAD = 100;
	private int THREAD_POOL_EXTRACT = 50;

	/**
	 * constructer with no parameter
	 */
	public ThreadPoolDoor() {
		// int THREAD_COUNT = Integer.parseInt(PropertiesUtil.getInstance()
		// .readValue("THREAD_COUNT").trim());

		this.THREAD_POOL_DOWNLOAD = Integer
				.parseInt(PropertyConfigurer.getContextProperty("downloading_thread_pool_size"));
		this.THREAD_POOL_EXTRACT = Integer
				.parseInt(PropertyConfigurer.getContextProperty("extracting_thread_pool_size"));
		LOG.info("--->>> ThreadPoolDoor: THREAD_POOL_DOWNLOAD = " + this.THREAD_POOL_DOWNLOAD
				+ ", THREAD_POOL_EXTRACT = " + this.THREAD_POOL_EXTRACT);

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
