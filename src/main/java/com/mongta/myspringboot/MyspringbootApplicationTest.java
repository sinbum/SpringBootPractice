package com.mongta.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyspringbootApplicationTest {

	public static void main(String[] args) {
//		SpringApplication.run(MyspringbootApplication.class, args);
		SpringApplication application = new SpringApplication(MyspringbootApplicationTest.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
//		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}
}
