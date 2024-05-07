package com.mindgate.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mindgate.main.thread.Task;

public class TaskMain {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			executorService.execute(new Task());
		}

	}
}
