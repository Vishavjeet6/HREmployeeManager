package com.nagarro.configuration;
/*
* Class name - ServletConfig
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 10-01-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 19-03-2020
*
* Description - Servlet Configuration File
*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"com.nagarro.controllers"})
public class ServletConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalView = new InternalResourceViewResolver();
		internalView.setSuffix(".jsp");
		return internalView;
	}
	
	@Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");
    }
}
