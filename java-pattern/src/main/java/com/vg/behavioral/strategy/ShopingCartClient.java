package com.vg.behavioral.strategy;

public class ShopingCartClient {
	public static void main(String[] str) {

		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(1, 100));
		cart.addItem(new Item(2, 200));

		CreditCardPaymentStrategy payment = new CreditCardPaymentStrategy(99999);

		cart.pay(payment);

		new ShopingCartClient();

	}

	ShopingCartClient() {
		Integer i = new Integer(10);
		call(i);
	}

	private static void call(Number n) {
		System.out.println("numb " + n);
	}

	private static void call(Integer n) {
		System.out.println("int " + n);
	}
}
