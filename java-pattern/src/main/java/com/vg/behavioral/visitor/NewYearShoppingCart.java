package com.vg.behavioral.visitor;

public class NewYearShoppingCart implements ShoppingCartVisitor {

	public int visit(Book book) {
		return book.getPrice() / 2;
	}

	public int visit(Fruit fruit) {
		return fruit.getPrice() / 2;
	}

}
