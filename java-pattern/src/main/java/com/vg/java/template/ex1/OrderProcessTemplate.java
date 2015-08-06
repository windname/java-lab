package com.vg.java.template.ex1;

public abstract class OrderProcessTemplate {
	public boolean isGift;

	protected abstract void doSelect();

	protected abstract void doPayment();

	protected final void giftWrap() {
		System.out.println("Gift wrap done.");
	}

	protected abstract void doDelivery();

	public final void processOrder() {
		doSelect();
		doPayment();
		if (isGift) {
			giftWrap();
		}
		doDelivery();
	}
}