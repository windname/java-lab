package com.vg.java.state.ex1;

public class LowerCaseState implements StringState {

	public void handleStr(StringContext stringContext, char ch) {
		System.out.print(String.valueOf(ch).toLowerCase());
	}

}
