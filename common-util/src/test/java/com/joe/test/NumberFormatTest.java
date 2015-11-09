package com.joe.test;

import java.text.NumberFormat;

/**
 * Created by admin on 2015/11/2.
 */
public class NumberFormatTest {

	public static void main(String[] args) {
		final NumberFormat currencyInstance = NumberFormat.getNumberInstance();
		currencyInstance.setMinimumFractionDigits(2);
		currencyInstance.setGroupingUsed(false);

		final Long[] dateStrings = {
				12345L, 6789L, 100000L, 56887L, 788845L
		};
		int threadNum = 6;
		Thread[] parseThreads = new Thread[threadNum];
		for (int i = 0; i < threadNum; i++) {
			parseThreads[i] = new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < dateStrings.length; j++) {
						try {
							System.out.println(Thread.currentThread().getName() + " " + currencyInstance.format(dateStrings[j]));
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
