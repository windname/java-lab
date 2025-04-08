package com.vg.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartClient {
	public static void main(String[] str) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Book("Wind name", 100));
		items.add(new Fruit("Apple", 10));

		int totalSum = 0;

		NewYearShoppingCart newYearVisitor = new NewYearShoppingCart();
		for (Item item : items) {
			totalSum += item.accept(newYearVisitor);
		}
		System.out.println("Total sum is " + totalSum);
	}

}
