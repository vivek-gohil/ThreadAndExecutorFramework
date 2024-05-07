package com.mindgate.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mindgate.main.domain.Order;
import com.mindgate.main.util.OrderProcessingUtil;

public class OrderMain {
	public static void main(String[] args) {
		Order order1 = new Order(101, 1, "Mouse", 600, new ArrayList<String>());
		Order order2 = new Order(102, 2, "Shirt", 800, new ArrayList<String>());
		Order order3 = new Order(103, 1, "Saree", 6000, new ArrayList<String>());
		Order order4 = new Order(104, 1, "Key Board", 5000, new ArrayList<String>());
		Order order5 = new Order(105, 1, "AC", 6000, new ArrayList<String>());

		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (Order order : orders) {
			 OrderProcessingUtil.doAsyncOrderProcessing(executorService, order);
			//OrderProcessingUtil.doOrderProcessing(executorService, order);
		}

		// OrderProcessingUtil.doOrderProcessing(executorService, orders);

	}

}
