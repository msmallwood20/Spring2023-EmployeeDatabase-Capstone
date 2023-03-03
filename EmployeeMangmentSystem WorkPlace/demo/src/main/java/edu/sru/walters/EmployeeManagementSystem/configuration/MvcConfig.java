package edu.sru.walters.EmployeeManagementSystem.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/registration").setViewName("registration");
		registry.addViewController("/loginpage").setViewName("loginpage");
		registry.addViewController("/dashboard").setViewName("dashboard");
		registry.addViewController("/accountseetings").setViewName("accountsettings");
		registry.addViewController("/timesheet").setViewName("timesheet");
		registry.addViewController("/manageusers").setViewName("manageusers");
	}
}
