package com.incubyte;
import static org.junit.Assert.assertEquals;




import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void firesExceptionOnNegativeNumber() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3");

		StringCalculator.add("-3");
	}
	
	@Test
	public void firesExceptionOnNegativeNumbersWithAllNumbersInExceptionMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -4,-5,-5");

		StringCalculator.add("1,-4,-5,-5,14");
	}
	
	@Test
	public void ignoresNumbersAbove1000() {
		assertEquals(StringCalculator.add("2,1001"), 2);
	}
	
}
