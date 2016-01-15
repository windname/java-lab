package com.vg.java.commander.ex2;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class SeparatorEqual {
	@Parameter(names = "-level")
	Integer level = 2;

	@Parameter(names = "-age", validateWith = PositiveInteger.class)
	Integer age;
}