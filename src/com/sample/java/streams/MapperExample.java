package com.sample.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Akshay", "chauhan", "Ravi", "Shankar", "Bismil");

		//ImperativeWay
		for (String name : names) {
			if (!name.equals("Akshay")){
				User user=new User(name);
				System.out.println(user);
			}
				
		}
		
		//Using Functional Interface
/*		names.stream()
				.filter(MapperExample::check)
				.map(new Function<String ,User>() {
					@Override
					public User apply(String name) {
						return new User(name);
					}			
				})
				.forEach(System.out::print);*/
		
		//Using Consumer Interface
/*		names.stream()
				.filter(MapperExample::check)
				.map(name -> {
					return new User(name);
				})
				.forEach(new Consumer<User>() {

					@Override
					public void accept(User user) {
						System.out.print(user);
						
					}
				});*/
		//Using Functional Programming
		names.stream()
				.filter(MapperExample::check)
				.map(User::new)
				.forEach(System.out::println);
		//To accumulate
		List<User> ls=names.stream()
							.filter(MapperExample::check)
							.map(User::new)
							.collect(Collectors.toList());


	}


	private static boolean check(String name) {
		return !name.equals("Akshay");
	}
	
	static class User{
		private String name;
		private Integer age= 30;
		
		public User(String name) {
			super();
			this.name = name;
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

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
		
	}
}
