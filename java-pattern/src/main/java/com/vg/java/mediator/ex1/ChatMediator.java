package com.vg.java.mediator.ex1;

public interface ChatMediator {

	public void sendMessage(String msg, User user);

	void addUser(User user);
}