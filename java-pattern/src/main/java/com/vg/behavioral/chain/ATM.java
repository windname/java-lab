package com.vg.behavioral.chain;

public class ATM {
	public void dispenseSum(int amount) {
		DispenseChain chain1 = new Dollar50Dispenser();
		DispenseChain chain2 = new Dollar20Dispenser();
		DispenseChain chain3 = new Dollar10Dispenser();

		chain1.setNextChain(chain2);
		chain2.setNextChain(chain3);
		chain1.dispense(new Currency(amount));
	}

	public static void main(String[] str) {
		(new ATM()).dispenseSum(230);
	}

}
