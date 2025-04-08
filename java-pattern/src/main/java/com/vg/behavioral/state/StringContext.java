package com.vg.behavioral.state;

public class StringContext {
	private StringState currentState;

	public StringContext() {
		currentState = new UpperCaseState();
	}

	public void setCurrentState(StringState currentState) {
		this.currentState = currentState;
	}

	public void handleStr(String str) {
		for (int i = 0; i < str.length(); i++) {
			currentState.handleStr(this, str.charAt(i));
		}
	}
}
