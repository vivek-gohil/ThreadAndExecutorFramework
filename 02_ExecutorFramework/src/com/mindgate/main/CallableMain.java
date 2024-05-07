package com.mindgate.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.mindgate.main.thread.CallableTask;

public class CallableMain {
	public static void main(String[] args) {
		System.out.println("main start");

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		System.out.println("ExecutorService is created");

		Future<Integer> future = executorService.submit(new CallableTask());
		System.out.println("Task is submitted");

		System.out.println("main is executing next lines");
		for (int i = 0; i < 10; i++) {
			System.out.println("main " + i);
		}

		try {
			System.out.println("main is waiting for result");
			int result = future.get();
			System.out.println("Result = " + result);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("main end");
	}
}
