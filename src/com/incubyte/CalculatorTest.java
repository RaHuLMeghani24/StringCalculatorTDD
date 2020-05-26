package com.incubyte;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.incubyte.StringCalculator;

public class CalculatorTest {
	
	
	
	@Test
	public void emptyStringReturnsZero(){	
		assertEquals(StringCalculator.add(""), 0);
	}
	
	@Test
	public void singleNumberReturnsItself(){	
		assertEquals(StringCalculator.add("1"), 1);
		assertEquals(StringCalculator.add("5"), 5);
	}
	
	@Test
	public void twoNumbersReturnsSumCommadelimited(){	
		assertEquals(StringCalculator.add("1,2"), 3);
		assertEquals(StringCalculator.add("5,1"), 6);
	}
	
	
}
