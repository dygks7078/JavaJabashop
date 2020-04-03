package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		
		http.authorizeRequests()
		.mvcMatchers("/", "/all/**").permitAll()		// /, /all/모든 
		.mvcMatchers("/admin/**").hasRole("ADMIN")		// /admin/모든  권한이 ADMIN이 필요하다.
		.anyRequest().authenticated();					// 그외다른요청에는 로그인만하면 되게 설정한다.
		
		
		//로그인 페이지를 사용자가 만들어 지정해 보자
		//http.formLogin().loginPage("/login").permitAll();

		http.formLogin();								// 스프링 시큐리티가 제공하는 로그인폼을 사용하겠다.
		http.httpBasic();								// http기본 프로토콜을 사용하겠습니다.
	}	
}