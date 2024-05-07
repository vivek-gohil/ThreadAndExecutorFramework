package com.mindgate.main.domain;

import java.util.List;

public class Order {
	private int orderId;
	private int quantity;
	private String discription;
	private double amount;
	private List<String> orderStatus;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, int quantity, String discription, double amount, List<String> orderStatus) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.discription = discription;
		this.amount = amount;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<String> getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(List<String> orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", discription=" + discription + ", amount="
				+ amount + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
}
