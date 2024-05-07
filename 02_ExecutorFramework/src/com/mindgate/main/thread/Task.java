package com.mindgate.main.thread;

public class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("Task started");
		System.out.println("Thread Name = " + Thread.currentThread().getName());
		System.out.println("Task completed");
	}
}
