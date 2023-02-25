package edu.sru.walters.EmployeeManagementSystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
@Configuration
public class SecurityConfig// extends WebSecurityConfiguration
{
	//Talks to the database
    @Autowired
	//private UserService userService;
    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	    	http
			.authorizeHttpRequests((requests) -> requests
//Specify that URLs are allowed by anyone. With Authenticate(Login), any links not in here auto require authenticate
				.requestMatchers("/", "/index", "/loginpage","/registration").permitAll()
				.anyRequest().authenticated()
			)
			//Login From reference 
			.formLogin((form) -> form
			//This indicates that we have a custom login page, instead of using the default login that comes with Spring Security
				.loginPage("/loginpage")
				
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
	
		return http.build();
    			
    }
//For Testing/Debugging, we are using User.withDefaultPasswordEncoder(), to create temp login in accounts     
    @Bean
	public UserDetailsService userDetailsService() {
    	UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
    	UserDetails admin = User.withDefaultPasswordEncoder()
    			.username("admin")
    			.password("password")
    			.roles("USER", "ADMIN")
    			.build();
    			

		return new InMemoryUserDetailsManager(user);
	}
}
