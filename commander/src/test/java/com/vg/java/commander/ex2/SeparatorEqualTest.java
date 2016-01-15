package com.vg.java.commander.ex2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.beust.jcommander.JCommander;

public class SeparatorEqualTest {

	@Test
	public void testParse() {
		SeparatorEqual args = new SeparatorEqual();
		new JCommander(args).parse("-level=3");
		
		assertEquals(new Integer(3),  args.level);
	}
	
	@Test
	public void testInt() {
		SeparatorEqual args = new SeparatorEqual();
		new JCommander(args).parse("-age=3");
		
		assertEquals(new Integer(3),  args.age);
	}

}
