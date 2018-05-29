package com.pyramid.rpc.crawler;

import java.util.PriorityQueue;

/**
 * 
 * @author leiming4
 * 
 * @description: PriorityQueue - FIFO
 *
 */
public class TestQueue {

	private PriorityQueue<Object> priorityQueue = null;

	public TestQueue() {
		priorityQueue = new PriorityQueue<Object>();
	}

	public boolean isQueueEmpty() {
		if (!priorityQueue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return priorityQueue.size();
	}

	public boolean addObject(Object obj) {
		return priorityQueue.add(obj);
	}

	public Object delObject() {
		return priorityQueue.poll();
	}

	public static TestQueue test = null;

	public static TestQueue getInstance() {
		if (test == null) {
			test = new TestQueue();
		}
		return test;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestQueue t = TestQueue.getInstance();

		boolean bool = false;
		int i = 0;
		while (!bool) {
			i++;
			if (t.addObject(i) != true) {
				bool = false;
			}
			try {
				System.out.println("after adding, the queue's size: " + t.getSize());
				System.out.println("poll object: " + t.delObject());
				System.out.println("after deleting, the queue's size: " + t.getSize());
				System.out.println(">>>-------------------------\n");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
