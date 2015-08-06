package com.vg.java.state.ex1;

public class UpperCaseState implements StringState {

	public void handleStr(StringContext stringContext, char ch) {
		if (ch == ':') {
			stringContext.setCurrentState(new LowerCaseState());
		}
		System.out.print(String.valueOf(ch).toUpperCase());
	}
}
