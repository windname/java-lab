package com.vg.behavioral.visitor;

public class Fruit extends Item {

	public Fruit(String name, int price) {
		super(name, price);
	}

	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}
