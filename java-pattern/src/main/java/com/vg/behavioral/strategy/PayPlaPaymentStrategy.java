package com.vg.behavioral.strategy;

public class PayPlaPaymentStrategy implements PaymentStrategy {
	private int account;

	public PayPlaPaymentStrategy(int account) {
		super();
		this.account = account;
	}

	public void pay(int sum) {
		System.out.println("Getting " + sum + " from paypal account " + account);
	}

}
