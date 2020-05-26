package com.incubyte;

import java.util.Arrays;
import java.util.stream.*;


public class StringCalculator {
	
	private String delimiter;
	private String numbers;

	private StringCalculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}



	public static int add(String input) {
		
		if(input.isEmpty()) return 0;
		
		StringCalculator calculator = extractInput(input);
			
		 
		return Arrays.stream(calculator.numbers.split(calculator.delimiter)).mapToInt(Integer::parseInt).sum();
			
		
	}
	
	private static StringCalculator extractInput(String input){
		
		StringCalculator calculator;
		
		
		if(input.startsWith("//")){
			String[] extract = input.split("\n",2);
			calculator =  new StringCalculator(extract[0].substring(2), extract[1]);
		}else {
			calculator = new StringCalculator(",|\n", input);
		}
		return calculator;
		
	}
}
