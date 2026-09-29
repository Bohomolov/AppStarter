package org.starter.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private static final String[] SWAGGER_WHITELIST = {
			"/swagger-ui.html",
			"/swagger-ui/**",
			"/v3/api-docs",
			"/v3/api-docs/**"
	};

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {

		http.authorizeHttpRequests((request) ->
				request.requestMatchers("/ping").permitAll()
						.requestMatchers(SWAGGER_WHITELIST).permitAll()
						.anyRequest().authenticated());

		return http.build();
	}
}
