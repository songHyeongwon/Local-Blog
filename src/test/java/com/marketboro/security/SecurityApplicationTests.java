package com.marketboro.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
class SecurityApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("isNumeric");
		System.out.println(isNumeric("daw123A"));
	}
	public boolean isNumeric(String str) {
		return Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", str);
	}
}
