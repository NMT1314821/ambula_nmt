package com.example.amb_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf((csrf)->csrf.disable())
		.authorizeHttpRequests((au)->{
			au.requestMatchers(HttpMethod.GET,"/api/**").hasRole("READER");
			au.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
			au.requestMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN");
			au.anyRequest().authenticated();
		})
		 
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public UserDetailsService userDatailsService()
	{
		UserDetails admin=User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
				
		
		UserDetails reader=User.builder()
				.username("reader")
				.password(passwordEncoder().encode("reader"))
				.roles("READER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,reader);
	}
	
}
