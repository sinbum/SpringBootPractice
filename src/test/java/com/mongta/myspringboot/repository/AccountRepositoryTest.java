package com.mongta.myspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongta.myspringboot.entity.Account;

@SpringBootTest
public class AccountRepositoryTest {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void account() throws Exception{
		
		Account account = new Account();
		account.setUsername("test");
		account.setPassword("ab1234");
		
		//DB에 object를 저장함 - insert
		
		Account savedAcct = accountRepository.save(account);
		System.out.println("ID"+ savedAcct.getId() + " Name " +savedAcct.getUsername() + "password" + savedAcct.getPassword());
		assertThat(savedAcct).isNotNull();
		
		Optional<Account> optional = accountRepository.findByUsername("mongta");
		if(optional.isPresent()) {
			Account mongta = optional.get();
			System.out.println( "optanal" + mongta.getUsername() + "");
		}
		
		Optional<Account> optional2 = accountRepository.findByUsername("tset");
		//orElseThrow 아규먼트 Supplier의 T get() 메서드를 재정의
		Account emptyAcct = optional2.orElseThrow(() -> new RuntimeException("Account Not Fount"));
		optional2.orElseGet(() -> new Account());
		
	}
}
