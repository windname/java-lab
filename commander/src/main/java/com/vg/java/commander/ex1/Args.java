package com.vg.java.commander.ex1;

import com.beust.jcommander.Parameter;

public class Args {
	@Parameter(names = "--verbose")
	private	boolean verbose;
	
	@Parameter(names = "--name")
	private String name;

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}