package com.mongta.myspringboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mongta.myspringboot.property.MongtaProperties;

//@Order(1)
@Component
public class MyRunner implements ApplicationRunner{
	
//	@Value("${mongta.name}")
//	private String name;
	
	@Value("${mongta.age}")
	private int age;
			
	@Autowired
	private MongtaProperties property;
	
	
	@Autowired
	private String hello;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("foo : " + args.containsOption("foo"));
		System.out.println("bar : " + args.containsOption("bar"));
//		System.out.println(name);
		System.out.println("나이는" + age + "입니다.");
		
		
		System.out.println("-------------------------------------------");
		System.out.println("property : "+ property.getName());
		System.out.println("property : "+ property.getAge());
		System.out.println("property : "+ property.getFullName());
		
		
		System.out.println("------------------------------");

		System.out.println(hello);
		
	}
	

	
	


	
}
