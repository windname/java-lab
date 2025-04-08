package com.vg.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void pay(PaymentStrategy strategy) {
		int sum = items.stream().mapToInt(Item::getPrice).sum();
		strategy.pay(sum);
	}
}
