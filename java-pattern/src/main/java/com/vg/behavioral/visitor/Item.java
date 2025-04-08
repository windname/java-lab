package com.vg.behavioral.visitor;

public abstract class Item {

	private String name;
	private int price;

	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	};

	public abstract int accept(ShoppingCartVisitor visitor);
}
