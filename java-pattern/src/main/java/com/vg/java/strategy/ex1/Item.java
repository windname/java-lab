package com.vg.java.strategy.ex1;

public class Item {
	private int itemId;
	private int price;

	public Item(int itemId, int price) {
		super();
		this.itemId = itemId;
		this.setPrice(price);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
