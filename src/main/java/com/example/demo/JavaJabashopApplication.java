package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



@SpringBootApplication
public class JavaJabashopApplication {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	public CommonsMultipartResolver multipartResolver()
	{
		return new CommonsMultipartResolver();
	}
	
	public static void main(String[] args) {
		
		//DBManager.insertMember(new MemberVo("test", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "홍길동", 20, "02-1234-1234", "USER"));
		//DBManager.insertMember(new MemberVo("master", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "고길동", 22, "02-1234-1234", "ADMIN"));

		SpringApplication.run(JavaJabashopApplication.class, args);
	}
	
}