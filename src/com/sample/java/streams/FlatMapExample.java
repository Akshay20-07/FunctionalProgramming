package com.sample.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		List<User> users = Arrays.asList(
				new User("Akshay", 24, Arrays.asList("1","23")),
				new User("Ravi", 21, Arrays.asList("2","22","4")),
				new User("Bismil", 28, Arrays.asList("5"))
		);

		//Using Functional Programming

		//To get the number 5
/*		Optional<Object> stringOptional=users.stream()
						.map(new Function<User, Stream<String> >() {
							@Override
							public Stream<String> apply(User user) {
								return user.getPhoneNumber().stream();
								
							}
						})
						.flatMap(new Function<Stream<String>, Stream<? extends Object>>() {		
							@Override
							public Stream<? extends Object> apply(Stream<String> phoneNumber) {
								
								return phoneNumber.filter(number-> number.equals("5"));
							}							
						}).findAny();*/
		
		Optional<String> stringOptional=users.stream()
												.map(user->user.getPhoneNumber().stream())
												.flatMap(phoneNumber->phoneNumber.filter(number->number.equals("5")))
												.findAny();
				
		stringOptional.ifPresent(System.out::println);


	}


	private static boolean check(String name) {
		return !name.equals("Akshay");
	}
	
	
	
	static class User{
		private String name;
		private Integer age= 30;
		private List<String> phoneNumber;
		

		
		public User(String name, Integer age, List<String> phoneNumber) {
			super();
			this.name = name;
			this.age = age;
			this.phoneNumber = phoneNumber;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}

		
		public List<String> getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(List<String> phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
		}


		
		
	}
}
