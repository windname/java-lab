package com.vg.behavioral.visitor;

public class Book extends Item {

	public Book(String name, int price) {
		super(name, price);
	}

	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
