package com.vg.behavioral.memento;

import java.util.LinkedList;
import java.util.Queue;

public class TextStateCarrier {
	Queue<TextMemento> states = new LinkedList<TextMemento>();

	public void setState(TextMemento state) {
		states.offer(state);
	}

	public TextMemento getState() {
		return states.poll();
	}
}
