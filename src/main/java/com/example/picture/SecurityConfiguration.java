package com.example.picture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    
    @Bean
	//enables form Login and HTTP basic auth
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests( registry -> {
			registry.requestMatchers("api/list/*").hasRole("ADMIN");
			registry.requestMatchers("/").anonymous();
		})
		.build();
	}

    @Bean
	// auth support in memory
	public UserDetailsService userDetailsService() {
		@SuppressWarnings("deprecation")
		UserDetails userDetails = User.withDefaultPasswordEncoder()
			.username("user")
			.password("password")
			.roles("USER")
			.build();

		@SuppressWarnings("deprecation")
		UserDetails adminDetails = User.withDefaultPasswordEncoder()
			.username("admin")
			.password("admin")
			.roles("ADMIN")
			.build();

		return new InMemoryUserDetailsManager(userDetails,adminDetails);
	}
}
