package com.vg.behavioral.memento;

public class ClientMemento {
	public static void main(String[] str) {
		TextUtil originator = new TextUtil();
		TextStateCarrier stateCarrier = new TextStateCarrier();
		Text text = new Text();
		text.setLine("first line");
		stateCarrier.setState(originator.setText(text));
		text.showText();

		text.setLine("second line");
		text.showText();

		text = originator.getText(text, stateCarrier.getState());
		text.showText();
	}
}
