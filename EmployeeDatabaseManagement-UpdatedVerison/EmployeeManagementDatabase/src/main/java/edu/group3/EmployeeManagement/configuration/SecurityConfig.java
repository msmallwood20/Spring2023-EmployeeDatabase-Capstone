/*package edu.group3.EmployeeManagement.configuration;

import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();

        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("USER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/index", "/registration", "/registrationsucces", "/loginsuccess", "/login", "/logout").permitAll()
				.requestMatchers("/css/**", "/js/**", "/Images/**").permitAll()
				.requestMatchers("/dashboard").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated()
			)
			.csrf().disable()
			.formLogin((form) -> form
				.loginPage("/login")
				.loginProcessingUrl("/loginsuccess")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
	
		return http.build();
	}

	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        return encoder;
	    }
}*/
