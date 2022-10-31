package com.alex.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PersonRespository personRespository;

	@BeforeEach
	public void beforeEach() {
		personRespository.deleteAll();
		Person alex = new Person("Alex");
		personRespository.save(alex);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void hasOnePerson() {
		assertEquals(1, personRespository.findAll().size());
	}
	

}
