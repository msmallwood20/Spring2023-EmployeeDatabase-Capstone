package edu.group3.EmployeeManagement.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/dashboard").setViewName("dashboard");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/loginsuccess").setViewName("loginsuccess");
		registry.addViewController("/registration").setViewName("registration");
		registry.addViewController("/registrationsucces").setViewName("registrationsucces");
		registry.addViewController("/manageusers").setViewName("manageusers");
		registry.addViewController("/addusers").setViewName("addusers");
		registry.addViewController("/createpassword").setViewName("createpassword");
		
	}
}
