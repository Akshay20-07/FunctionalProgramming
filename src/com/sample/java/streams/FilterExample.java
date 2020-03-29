package com.sample.java.streams;

import java.util.Arrays;
import java.util.List;

public class FilterExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Akshay", "chauhan", "Ravi", "Shankar", "Bismil");

		// Oldway
		for (String name : names) {
			if (!name.equals("Akshay"))
				System.out.println(name);
		}

		/*names.stream()
				.filter(new Predicate<String>() {
						@Override
						public boolean test(String name) {
			
							return !name.equals("Akshay");
						}
						})
						.forEach(name -> System.out.print(name));*/

		
		 /*names.stream()
		 		.filter(name -> check(name)) 
		 		.forEach(name ->System.out.print(name));*/
		 
		
		names.stream()
				.filter(FilterExample::check)
				.forEach(System.out::print);

	}


	private static boolean check(String name) {
		return !name.equals("Akshay");
	}
}
