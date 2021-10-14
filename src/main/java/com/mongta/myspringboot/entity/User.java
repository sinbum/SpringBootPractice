package com.mongta.myspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@JacksonXmlProperty
	private String name;
	
	@Column(unique = true)
	@JacksonXmlProperty
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
}
