package com.joe.learn.thread;

public class SynchronizedTest {

	public static void main(final String[] args) {

		class Test implements Runnable{

			private int ticket=10;

			@Override
			public void run() {
				int i=10;
				while(i>0){
					i--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sale();
				}
			}

//			private synchronized void sale(){
//				if(ticket>0) {
//					System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余：" + ticket--);
//				}
//			}

			private void sale(){
				synchronized (args) {
					if (ticket > 0) {
						System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余：" + ticket--);
					}
				}
			}
		}

		Test test=new Test();
		new Thread(test, "A窗口").start();
		new Thread(test, "B窗口").start();
		new Thread(test, "C窗口").start();

	}


}
