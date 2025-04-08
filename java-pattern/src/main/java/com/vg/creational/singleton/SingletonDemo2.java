package com.vg.creational.singleton;

/**
 * an easyer implementation of singleton then double-checked locking.
 * potentially has a lower concurrency. Lazy initialization is better than eager
 * 
 * @author vladimir
 *
 */
public class SingletonDemo2 {
	private static volatile SingletonDemo2 instance = null;

	private SingletonDemo2() {
	}

	public static synchronized SingletonDemo2 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2();
		}

		return instance;
	}

	public static void main(String[] str) {
		System.out.println("instance1=" + SingletonDemo2.getInstance());
		System.out.println("instance2=" + SingletonDemo2.getInstance());
	}
}
