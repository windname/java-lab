package com.vg.java.visitor.ex1;

public class Book extends Item {

	public Book(String name, int price) {
		super(name, price);
	}

	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
