package com.vg.java.commander.ex1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.beust.jcommander.JCommander;

public class ArgsTest {

	@Test
	public void testArgs() {
		Args args = new Args();
		new JCommander(args).parse("--name", "Vladimir", "--verbose");
		
		assertEquals("Vladimir", args.getName());
		assertTrue(args.isVerbose());
	}

}
