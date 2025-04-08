package com.vg.behavioral.state;

public class Client {
	public static void main(String[] args) {
		String str = "hellO: WorlD";
		StringContext context = new StringContext();
		context.handleStr(str);
	}
}
