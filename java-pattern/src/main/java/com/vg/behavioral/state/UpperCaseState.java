package com.vg.behavioral.state;

public class UpperCaseState implements StringState {

	public void handleStr(StringContext stringContext, char ch) {
		if (ch == ':') {
			stringContext.setCurrentState(new LowerCaseState());
		}
		System.out.print(String.valueOf(ch).toUpperCase());
	}
}
