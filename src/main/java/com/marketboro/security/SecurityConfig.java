package com.marketboro.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
				.antMatchers("/",  "/index**", "/join**", "/login**").permitAll() //전체 접근 허용
				//.antMatchers("/user/*").hasRole("MEMBER")
				.antMatchers("/admin**").hasRole("ADMIN") //관리자만
				.anyRequest().authenticated()
				.and().formLogin().defaultSuccessUrl("/main");
	}
}
