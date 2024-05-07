package com.mindgate.main.thread;

import java.util.List;
import java.util.concurrent.Callable;

import com.mindgate.main.domain.Order;

public class Dispatch implements Callable<Order> {
	private Order order;

	public Dispatch(Order order) {
		super();
		this.order = order;
	}

	@Override
	public Order call() throws Exception {
		List<String> orderStatus = order.getOrderStatus();
		Thread.sleep(500);
		orderStatus.add("Dispatched");
		System.out.println(order);
		return order;
	}

}
