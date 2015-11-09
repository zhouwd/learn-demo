package com.joe.learn.thread;

public class VolatileTest {

	public static void main(String[] args) {

		class Test implements  Runnable{


			//使用volatile 关键字，将ticket域同步.但是实际上并未生效。原因待查。
			//解释一：用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。详见：http://www.cnblogs.com/aigongsi/archive/2012/04/01/2429166.html
			private volatile int ticket =10;


			@Override
			public void run() {

				int i=10;
				while(i>0) {
					i--;
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					sale();
				}


			}

			private void sale(){
				if(ticket>0) {
					System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余：" + ticket--);
				}
			}
		}

		Test test=new Test();
		new Thread(test,"A窗口").start();
		new Thread(test,"B窗口").start();
		new Thread(test,"C窗口").start();

	}



}
