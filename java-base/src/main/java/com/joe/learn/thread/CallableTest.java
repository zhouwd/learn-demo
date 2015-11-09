package com.joe.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		class Test implements Callable<String> {

			private volatile  int ticket=10;


			private void sale(){
				synchronized (this) {
					if (ticket > 0) {
						System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余：" + ticket--);
					}
				}
			}



			@Override
			public String call() throws Exception {

				int i=10;
				while (i>0){
					i--;
					Thread.sleep(1000);
					sale();
				}


				return Thread.currentThread().getName()+" 下班了。";
			}
		}

		Test test = new Test();
		FutureTask<String> futureATask = new FutureTask<String>(test);
		FutureTask<String> futureBTask = new FutureTask<String>(test);
		FutureTask<String> futureCTask = new FutureTask<String>(test);




		new Thread(futureATask, "A窗口").start();
		new Thread(futureBTask, "B窗口").start();
		new Thread(futureCTask, "C窗口").start();

		System.out.println(futureATask.get()+"");
		System.out.println(futureBTask.get()+"");
		System.out.println(futureCTask.get()+"");

	}

}
