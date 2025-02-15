//package com.example.MyDB.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration{
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http
//			.authorizeHttpRequests((requests)->
//			requests.antMatchers("/user_cart/**").hasRole("USER")
//			.anyRequest().authenticated());
//			
//	}
//}
