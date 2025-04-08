package com.vg.behavioral.memento;

public class Text {
	private String line;
	private boolean bold;

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public void showText() {
		if (bold) {
			System.out.println("<b>" + line + "<b>");
		} else {
			System.out.println(line);
		}
	}
}
