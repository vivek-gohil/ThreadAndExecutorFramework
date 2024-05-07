package com.mindgate.main.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println("Thread is generating number");
		Thread.sleep(3000);
		System.out.println("number is generated successfully");
		return new Random().nextInt();
	}
}
