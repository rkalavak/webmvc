package com.kalavakuri.webmvc.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.kalavakuri.webmvc.business.BusinessConfig;
import com.kalavakuri.webmvc.web.SpringMVCConfig;

public class SpringInitialization extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {BusinessConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
