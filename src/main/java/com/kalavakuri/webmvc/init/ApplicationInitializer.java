package com.kalavakuri.webmvc.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	private static Logger logger = Logger.getLogger(ApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) {

		// Create the 'root' Spring application context
		logger.info("Create the 'root' Spring application context");
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.setConfigLocation("com.kalavakuri.webmvc");

		// Manage the lifecycle of the root application context
		logger.info("Manage the lifecycle of the root application context");
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// Register and map the dispatcher servlet
		logger.info("Register and map the dispatcher servlet");
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		// DataSource profile activation
		// servletContext.setInitParameter("spring.profiles.active", "hikari_ds");
		logger.info("DataSource profile activation");
		servletContext.setInitParameter("spring.profiles.active", "basic_ds");
	}

}
