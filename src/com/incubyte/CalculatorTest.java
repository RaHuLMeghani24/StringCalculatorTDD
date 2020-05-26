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
	public void twoNumbersReturnsSumCommaDelimited(){	
		assertEquals(StringCalculator.add("1,2"), 3);
		assertEquals(StringCalculator.add("5,1"), 6);
	}
	
	//Test to handle n number of numbers in input
	
	@Test
	public void threeNumbersReturnsSumCommaDelimited(){	
		assertEquals(StringCalculator.add("1,2"), 3);
		assertEquals(StringCalculator.add("5,1"), 6);
	}
	
	@Test
	public void twoNumbersReturnsSumNewLineDelimited(){	
		assertEquals(StringCalculator.add("2\n3"), 5);
		assertEquals(StringCalculator.add("5\n1"), 6);
	}	
	
	@Test
	public void sumsNumberDelimitedByCommaOrNewLine(){	
		assertEquals(StringCalculator.add("2,3\n1"), 6);
		assertEquals(StringCalculator.add("5\n1,1"), 7);
	}
	
	@Test
	public void usesCustomDelimiterSpecified(){	
		assertEquals(StringCalculator.add("//;\n1;3"), 4);
		
	}
	
}
