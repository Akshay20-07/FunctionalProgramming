package com.sample.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperIntExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Akshay", "chauhan", "Ravi", "Shankar", "Bismil");

		//ImperativeWay
		for (String name : names) {
			if (!name.equals("Akshay")){
				User user=new User(name);
				System.out.println(user);
			}
				
		}

		//To accumulate
		List<User> ls=names.stream()
							.filter(MapperIntExample::check)
							.map(User::new)
							.collect(Collectors.toList());
/*		int sum=ls.stream()
			.mapToInt(user->{
				return user.getAge();
			}).sum();*/
		
		int sum=ls.stream()
				.mapToInt(User::getAge).sum();
		
		System.out.println("Sum is"+sum);

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
