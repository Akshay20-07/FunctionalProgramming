package com.sample.java.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamExample {
	
	public static void main(String[] args) {
		
		//Peek Operation for debugging and should be performed before terminate operation 
		List<String> ls=Stream.of("One","Two","Three")
				.filter(element -> !element.equals("One"))
				.peek(obj -> System.out.println("peeked "+ obj))
				.collect(Collectors.toList());
		
		//Skip some value
		IntStream.of(1,23,4,22,78,3,2)
					.skip(2)
					.filter(i -> i>5)
					.forEach(System.out::println);

	}

}
