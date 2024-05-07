package com.mindgate.main.thread;

import java.util.List;
import java.util.concurrent.Callable;

import com.mindgate.main.domain.Order;

public class SendMail implements Callable<Order> {
	private Order order;

	public SendMail(Order order) {
		super();
		this.order = order;
	}

	@Override
	public Order call() throws Exception {
		List<String> orderStatus = order.getOrderStatus();
		Thread.sleep(500);
		orderStatus.add("Email Sent");
		System.out.println(order);
		return order;
	}

}
