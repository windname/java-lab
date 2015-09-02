package com.vg.java.visitor.ex1;

public interface ShoppingCartVisitor {
	int visit(Book book);

	int visit(Fruit fruit);
}
