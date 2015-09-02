package com.vg.java.core.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestForEach {
	public static void main(String[] str) {
		List<String> list = new ArrayList<String>() {
			{
				add("One");
				add("Two");
				add("Three");
			}
		};

		/**
		 * method forEach expects inner clas Consumer but it's possible to
		 * replace it with lambda
		 */
		list.forEach((String name) -> System.out.println("number is " + name));

		list.forEach(name -> System.out.println("number is " + name));

		/**
		 * use reference to method
		 */
		list.forEach(System.out::println);

		List<String> upperCaseList = new ArrayList<String>();
		list.forEach(name -> upperCaseList.add(name.toUpperCase()));
		upperCaseList.forEach(System.out::println);

	}
}
