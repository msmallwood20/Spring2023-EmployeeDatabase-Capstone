package edu.group3.EmployeeManagement.configuration;

import java.net.URL;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import edu.group3.EmployeeManagement.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new MyUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/index", "/registration", "/registrationsucces", "/loginsuccess", "/login", "/logout", "/createpassword").permitAll()
				.requestMatchers("/css/**", "/js/**", "/Images/**").permitAll()
				.requestMatchers("/payrollAdmin").hasAnyAuthority("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.usernameParameter("username")
				.passwordParameter("password")
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/loginsuccess")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
	
		return http.build();
	}

	  @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	    
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	 
}
