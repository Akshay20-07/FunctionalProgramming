package com.sample.java.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileOperations {

	public static void main(String[] args) {
		
		try {
			List<String> str=Files.lines(Paths.get("../java8Practice/resources/pom.xml"))
					.filter(check->check.contains("name"))
					.map(line-> line.replace("name", "")
							.replace("<","")
							.replace(">", "")
							.replace("/","").trim())
					.collect(Collectors.toList());
			System.out.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
