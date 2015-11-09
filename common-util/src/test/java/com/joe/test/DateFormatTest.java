package test;

import java.text.SimpleDateFormat;

/**
 * @author zhenwei.liu created on 2013 13-8-29 下午5:35
 * @version $Id$
 */
public class DateFormatTest extends Thread {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");

	public static void main(String[] args) {

		final String[] dateStrings = {
				"2014-04-30 18:51:01,611",
				"2014-04-30 18:51:01,461",
				"2014-04-30 18:51:01,361",
				"2014-04-30 18:51:01,261",
				"2014-04-30 18:51:01,161",
		};
		int threadNum = 5;
		Thread[] parseThreads = new Thread[threadNum];
		for (int i = 0; i < threadNum; i++) {
			parseThreads[i] = new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < dateStrings.length; j++) {
						try {
							System.out.println(Thread.currentThread().getName() + " " + sdf.parse(dateStrings[j]));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			parseThreads[i].start();
		}

		for (int i = 0; i < threadNum; i++) {
			try {
				parseThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}