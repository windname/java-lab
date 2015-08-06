package com.vg.java.template.ex1;

public class TemplateMethodPatternClient {
	public static void main(String... args) {
		System.out.println("$$$$$$$ NetOrder instance of the Template: $$$$$$$");
		OrderProcessTemplate netOrder = new InternetOrder();
		netOrder.processOrder();
		System.out.println("$$$$$$$ StoreOrder instance of the Template: $$$$$$$");
		OrderProcessTemplate storeOrder = new StoreOrder();
		storeOrder.isGift = true;
		storeOrder.processOrder();
	}
}
