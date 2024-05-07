package com.mindgate.main.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.mindgate.main.domain.Order;
import com.mindgate.main.thread.Dispatch;
import com.mindgate.main.thread.EnrichOrder;
import com.mindgate.main.thread.FetchOrder;
import com.mindgate.main.thread.Payment;
import com.mindgate.main.thread.SendMail;

public class OrderProcessingUtil {

	public static void doOrderProcessing(ExecutorService executorService, Order order) {
		Order fetchedOrder = fetchOrder(executorService, order);
		Order enrichOrder = enrichOrder(executorService, fetchedOrder);
		Order paymentOrder = payment(executorService, enrichOrder);
		Order dispatchOrder = dispatch(executorService, paymentOrder);
		sendEmail(executorService, dispatchOrder);
	}

	public static void doAsyncOrderProcessing(ExecutorService executorService, Order order) {
//		CompletableFuture.supplyAsync(new Supplier<Order>() {
//			@Override
//			public Order get() {
//				return fetchOrder(executorService, order);
//			}
//		}).thenApply(new Function<Order, Order>() {
//			@Override
//			public Order apply(Order order) {
//				return enrichOrder(executorService, order);
//			}
//		}).thenApply(new Function<Order, Order>() {
//
//			@Override
//			public Order apply(Order order) {
//				return payment(executorService, order);
//			}
//		}).thenApply(new Function<Order, Order>() {
//			@Override
//			public Order apply(Order order) {
//				return dispatch(executorService, order);
//			}
//		}).thenAccept(new Consumer<Order>() {
//
//			@Override
//			public void accept(Order order) {
//
//				sendEmail(executorService, order);
//			}
//		});

		CompletableFuture.supplyAsync(() -> fetchOrder(executorService, order))
				.thenApply(o -> enrichOrder(executorService, o)).thenApply(o -> payment(executorService, o))
				.thenApply(o -> dispatch(executorService, o)).thenAccept(o -> sendEmail(executorService, o));
	}

	public static Order fetchOrder(ExecutorService executorService, Order order) {

		try {
			FetchOrder fetchOrder = new FetchOrder(order);
			Future<Order> fetchFuture = executorService.submit(fetchOrder);
			Order updatedFetchOrder = fetchFuture.get();
			return updatedFetchOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Order enrichOrder(ExecutorService executorService, Order order) {

		try {
			EnrichOrder enrichOrder = new EnrichOrder(order);
			Future<Order> enrichFuture = executorService.submit(enrichOrder);
			Order updatedEnrichOrder;
			updatedEnrichOrder = enrichFuture.get();
			return updatedEnrichOrder;
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static Order payment(ExecutorService executorService, Order order) {

		try {
			Payment paymentOrder = new Payment(order);
			Future<Order> paymentFuture = executorService.submit(paymentOrder);
			Order updatedPaymentOrder = paymentFuture.get();
			return updatedPaymentOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Order dispatch(ExecutorService executorService, Order order) {

		try {
			Dispatch dispatchOrder = new Dispatch(order);
			Future<Order> dispatchFuture = executorService.submit(dispatchOrder);
			Order updatedDispatchOrder = dispatchFuture.get();
			return updatedDispatchOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Order sendEmail(ExecutorService executorService, Order order) {

		try {
			SendMail sendEmailOrder = new SendMail(order);
			Future<Order> sendEmailFuture = executorService.submit(sendEmailOrder);
			Order updatedSendEmailOrder = sendEmailFuture.get();
			return updatedSendEmailOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void doOrderProcessing(ExecutorService executorService, List<Order> orders) {

		for (Order order : orders) {

			try {
				FetchOrder fetchOrder = new FetchOrder(order);
				Future<Order> fetchFuture = executorService.submit(fetchOrder);
				Order updatedFetchOrder = fetchFuture.get();
				System.out.println(updatedFetchOrder);

				EnrichOrder enrichOrder = new EnrichOrder(updatedFetchOrder);
				Future<Order> enrichFuture = executorService.submit(enrichOrder);
				Order updatedEnrichOrder = enrichFuture.get();
				System.out.println(updatedEnrichOrder);

				Payment paymentOrder = new Payment(updatedEnrichOrder);
				Future<Order> paymentFuture = executorService.submit(paymentOrder);
				Order updatedPaymentOrder = paymentFuture.get();
				System.out.println(updatedPaymentOrder);

				Dispatch dispatchOrder = new Dispatch(updatedPaymentOrder);
				Future<Order> dispatchFuture = executorService.submit(dispatchOrder);
				Order updatedDispatchOrder = dispatchFuture.get();
				System.out.println(updatedDispatchOrder);

				SendMail sendEmailOrder = new SendMail(updatedDispatchOrder);
				Future<Order> sendEmailFuture = executorService.submit(sendEmailOrder);
				Order updatedSendEmailOrder = sendEmailFuture.get();
				System.out.println(updatedSendEmailOrder);

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
