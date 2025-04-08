package com.vg.behavioral.chain;

public abstract class DispenseChain {

	private int nominal;
	private DispenseChain nextChain;

	public DispenseChain(int nominal) {
		this.nominal = nominal;
	}

	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	public void dispense(Currency cur) {
		if (cur.getAmount() >= nominal) {
			int num = cur.getAmount() / nominal;
			int remainder = cur.getAmount() % nominal;
			System.out.println("Dispensing " + num + " with " + nominal + "$");
			if (remainder != 0)
				this.nextChain.dispense(new Currency(remainder));
		} else {
			this.nextChain.dispense(cur);
		}
	}
}
