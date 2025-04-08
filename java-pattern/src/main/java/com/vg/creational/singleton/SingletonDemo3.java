package com.vg.creational.singleton;

/**
 * SingletonEnum class may have privat fields for example dbSource and private
 * constructor to initialize dbSource
 * 
 * @author vladimir
 *
 */
public class SingletonDemo3 {

	public enum SingletonEnum {
		INSTANCE;
		public void doStuff() {
			System.out.println("Singleton using Enum");
		}
	}

	public static void main(String[] args) {
		SingletonEnum.INSTANCE.doStuff();
	}
}
