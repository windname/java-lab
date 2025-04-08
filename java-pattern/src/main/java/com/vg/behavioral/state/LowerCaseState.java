package com.vg.behavioral.state;

public class LowerCaseState implements StringState {

	public void handleStr(StringContext stringContext, char ch) {
		System.out.print(String.valueOf(ch).toLowerCase());
	}

}
