package com.vg.java.strategy.ex1;

public class CreditCardPaymentStrategy implements PaymentStrategy {
	int cardNumber;

	public CreditCardPaymentStrategy(int cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}

	public void pay(int sum) {
		System.out.println("Getting " + sum + " from card " + cardNumber);
	}

}
