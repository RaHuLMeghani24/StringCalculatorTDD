package com.incubyte;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.incubyte.StringCalculator;

public class CalculatorTest {
	
	
	
	@Test
	public void emptyStringReturnsZero(){	
		assertEquals(StringCalculator.add(""), 0);
	}
	
	
}
