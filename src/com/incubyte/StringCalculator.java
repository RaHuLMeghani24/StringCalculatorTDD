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
		
		return extractInput(input).sum();
		
		
	}
	
	private int sum(){
		
		return Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).sum();
	}
	
	private static StringCalculator extractInput(String input){
		
		StringCalculator calculator;
		
		
		if(input.startsWith("//")){
			String[] extract = input.split("\n",2);
			return  new StringCalculator(extract[0].substring(2), extract[1]);
		}else {
			return new StringCalculator(",|\n", input);
		}
	
		
	}
}
