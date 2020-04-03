package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVo;

@SpringBootApplication
public class JavaJabashopApplication {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	
	
	public static void main(String[] args) {
		
		DBManager.insertMember(new MemberVo("test", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "홍길동", 20, "02-1234-1234", "USER"));
		
		SpringApplication.run(JavaJabashopApplication.class, args);
	}
	
}