package com.mongta.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("base")
@Configuration
public class BaseConfiguration {

	@Bean
	public String hello() {
		return "Base Hello! base 실행";
	}
}
