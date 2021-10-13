package com.mongta.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mongta.myspringboot.property.MongtaProperties;

//@Order(1)
@Component
public class MyRunner implements ApplicationRunner{
	
	//logger 생성
	Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
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
		System.out.println("Logger 구현 클래스 이름 : "+ logger.getClass().getName());
		
		logger.debug("foo : " + args.containsOption("foo"));
		logger.debug("bar : " + args.containsOption("bar"));
//		System.out.println(name);
		logger.debug("나이는" + age + "입니다.");
		
		
		logger.info("-------------------------------------------");
		logger.info("property : "+ property.getName());
		logger.info("property : "+ property.getAge());
		logger.info("property : "+ property.getFullName());
		
		
		logger.info("------------------------------");

		logger.info(hello);
		
	}
	

	
	


	
}
