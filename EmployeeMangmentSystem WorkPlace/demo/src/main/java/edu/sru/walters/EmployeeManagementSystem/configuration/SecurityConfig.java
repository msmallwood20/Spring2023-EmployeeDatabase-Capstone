package edu.sru.walters.EmployeeManagementSystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.sru.walters.EmployeeManagementSystem.service.UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfig
{
	//Talks to the database
    @Autowired
	private UserService userService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	    	http.csrf().disable()
			.authorizeHttpRequests((requests) -> requests
//Specify that URLs are allowed by anyone. With Authenticate(Login), any links not in here auto require authenticate
				.requestMatchers("/", "/index", "/loginpage", "/login", "/registration").permitAll()
				.anyRequest().authenticated()
			)
			//Login From reference 
			.formLogin().permitAll()
			//This indicates that we have a custom login page, instead of using the default login that comes with Spring Security
            .loginPage("/loginpage")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/dashboard", true)
            .and()
            .logout()
            .logoutUrl("/");
	    	
		return http.build();
    			
    }
//For Testing/Debugging, we are using User.withDefaultPasswordEncoder(), to create temp login in accounts     
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
          .withUsername("user")
          .password(passwordEncoder().encode("userPass"))
          .roles("USER").build());
        manager.createUser(User
          .withUsername("admin")
          .password(passwordEncoder().encode("adminPass"))
          .roles("ADMIN").build());
        return manager;
    }
    
    @Bean
    public AuthenticationEntryPoint loginURLLauthenticationEntyPoint()
    {
    	return new LoginUrlAuthenticationEntryPoint("/dashboard");
    }
    
    
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Bean
    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
            EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
        contextSourceFactoryBean.setPort(0);
        return contextSourceFactoryBean;
    }
	
    @Bean
    public static boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();

    }
}
