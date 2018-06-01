package com.pyramid.utils.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;

/**
 * Thread Utils：
 * 
 * @author leiming4
 *
 */
public class ThreadUtils {

	private static final Logger LOG = Logger.getLogger(ThreadUtils.class);

	/**
	 * 通过线程组获得线程
	 *
	 * @param threadId
	 * @return
	 */
	public static Thread findThread(long threadId) {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		while (group != null) {
			Thread[] threads = new Thread[(int) (group.activeCount() * 1.2)];
			int count = group.enumerate(threads, true);
			for (int i = 0; i < count; i++) {
				if (threadId == threads[i].getId()) {
					return threads[i];
				}
			}
			group = group.getParent();
		}
		return null;
	}

	public static void main(String[] args) {

		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list.get(9));

		list.remove(9);
		list.forEach(x -> System.out.println(x));

		System.exit(0);

		// -------------------------------------------------------- //

		Thread t = new Thread(new InnerRunnable());
		t.start();
		LOG.info("        thread: " + t);
		long threadId = t.getId();

		// 一：通过线程组遍历获得线程
		Thread s = findThread(threadId);
		LOG.info("   find thread: " + s);
		LOG.info("current thread: " + Thread.currentThread());

		// 二：通过 JMX 可以通过线程 ID 获得线程信息
		ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
		ThreadInfo info = tmx.getThreadInfo(threadId);
		LOG.info("ThreadState[" + threadId + "]: " + info.getThreadState());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		s.interrupt();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static class InnerRunnable implements Runnable {

		public void run() {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					LOG.info("--->>> " + UUID.randomUUID());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("mythread is interrupted!");
			}
		}
	}

}
