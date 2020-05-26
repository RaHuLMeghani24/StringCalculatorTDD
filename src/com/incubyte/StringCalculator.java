package com.incubyte;

import java.util.Arrays;
import java.util.stream.*;


public class StringCalculator {



	public static int add(String input) {
		
		if(input.isEmpty()) return 0;
		else{
			
			Stream<String> numbers = Arrays.stream(input.split(",|\n"));
			return numbers.mapToInt(Integer::parseInt).sum();
			
		}
		
		
	}
}
