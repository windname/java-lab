package com.vg.creational.singleton;

/**
 * Example of "Double-checked locking" implementation of singleton pattern
 * 
 * @author vladimir
 *
 */
public class SingletonDemo1 {
	private static volatile SingletonDemo1 instance;

	private SingletonDemo1() {
	}

	public static SingletonDemo1 getInstance() {
		if (instance == null) {
			synchronized (SingletonDemo1.class) {
				if (instance == null) {
					instance = new SingletonDemo1();
				}
			}
		}

		return instance;
	}

	public static void main(String[] str) {
		System.out.println("instance1=" + SingletonDemo1.getInstance());
		System.out.println("instance2=" + SingletonDemo1.getInstance());
	}
}
