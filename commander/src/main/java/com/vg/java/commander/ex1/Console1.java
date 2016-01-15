package com.vg.java.commander.ex1;

import com.beust.jcommander.JCommander;

public class Console1 {
	public static void main(String[] argv) {
		argv = new String[] { "--name", "Vlad" };
		Args args = new Args();
		new JCommander(args).parse(argv);

		System.out.println("Hello " + args.getName() + ", verbose is: " + args.isVerbose());
	}
}
