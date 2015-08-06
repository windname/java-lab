package com.vg.java.state.ex1;

public class Client {
	public static void main(String[] args) {
		String str = "hellO: WorlD";
		StringContext context = new StringContext();
		context.handleStr(str);
	}
}
