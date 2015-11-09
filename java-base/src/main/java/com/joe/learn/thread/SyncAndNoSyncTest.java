package com.joe.learn.thread;

/**
 * this has a synchronized method and a no_synchronized method.
 */
public class SyncAndNoSyncTest {


	public static void main(String[] args) {
		class Counter implements Runnable {

			private int count;

			public void countAdd() {
				synchronized (this) {
					for (int i = 0; i < 5; i++) {
						try {
							System.out.println(Thread.currentThread().getName() + ":count:" + System.currentTimeMillis() + ":" + (count++));
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}

			public void printCount() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + ":print:" + System.currentTimeMillis() + ":" + count);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}


			@Override
			public void run() {

				String threadName = Thread.currentThread().getName();
				if ("A".equals(threadName)) {
					countAdd();
				} else if ("B".equals(threadName)) {
					printCount();
				}

			}
		}

		Counter counter = new Counter();
		Thread threadA = new Thread(counter, "A");
		Thread threadB = new Thread(counter, "B");
		threadA.start();
		threadB.start();

	}


}
