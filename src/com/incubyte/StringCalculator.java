package com.incubyte;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.*;


public class StringCalculator {
	
	private String delimiter;
	private String numbers;

	private StringCalculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}



	public static int add(String input) {		
		return extractInput(input).sum();
	}
	
	private int sum(){
		
		checkNegativeNumbersIfAny();
		return extractNumbers().sum();
	}
	
	private void checkNegativeNumbersIfAny(){
		String negativeNumberSequence = extractNumbers().filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if (!negativeNumberSequence.isEmpty()) {
			throw new IllegalArgumentException("negative number: " + negativeNumberSequence);
		}
		
	}
	
	private IntStream extractNumbers(){
		if(numbers.isEmpty()) return IntStream.empty();
		else
			return Stream.of(numbers.split(delimiter)).mapToInt(Integer::parseInt).filter(n -> n<1001);
		
	}
	
	private static StringCalculator extractInput(String input){
		
	
		if(input.startsWith("//")){
			String[] extract = input.split("\n",2);
			
			return  new StringCalculator(extractDelimiter(extract[0]), extract[1]);
		}else {
			return new StringCalculator(",|\n", input);
		}
	}
	
	private static String extractDelimiter(String header){
		return Pattern.quote(header.substring(2));
		
	}
}
