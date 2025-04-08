package com.vg.behavioral.memento;

public class TextUtil {
	public TextMemento setText(Text text) {
		TextMemento memento = new TextMemento();
		memento.setLine(text.getLine());
		memento.setBold(text.isBold());
		return memento;
	}

	public Text getText(Text currentText, TextMemento memento) {
		currentText.setLine(memento.getLine());
		currentText.setBold(memento.isBold());
		return currentText;
	}
}
