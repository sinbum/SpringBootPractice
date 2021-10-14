package com.mongta.myspringboot;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LambdaTest {
	//이터러블은 리스트의 상위 객체이다.
	@Test
	public void iterable() throws Exception{
		List<String> list = List.of("aa","bb","cc");
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		//람다식의 표현
		list.forEach(value -> System.out.println(value + "-------------------"));
		
		//Method Reference
		list.forEach(System.out::println);
		
	}
	
	
	
	
	@Test @Disabled
	public void lambda() throws Exception{
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
		});
		t1.setName("몽타");
		t1.start();
		
		
		
		//람다식의 자바스크립트 표현
		/*
		 * function add(n1, n2){ return n1 + n2; }
		 * 
		 * var result = add(10,20) console.log(result)
		 * 
		 * 
		 * 
		 * //arrow function var add_result = (n1,n2) => n1+n2;
		 * console.log(add_result(10,10));
		 */
		
		//t1을 람다식으로 표현한 예
		
		//추상메서드의 이너클래스 혹은 익명함수를 사용하는 경우에 람다식을 이용하여 편하고 간단하게 사용할 수 있다.
		Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		
		
		
		
		
		
	}
}
