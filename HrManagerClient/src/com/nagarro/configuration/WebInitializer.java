package com.nagarro.configuration;
/*
* Class name - WebInitializer
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 17-03-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 19-03-2020
*
* Description -  Web Initializer Configuration File
*/
import java.io.File;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringConfig.class}; 
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	 @Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	        // upload temp file will put here
	        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
	        // register a MultipartConfigElement
	        MultipartConfigElement multipartConfigElement =
	                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
	                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
	        registration.setMultipartConfig(multipartConfigElement);
	    }
}
