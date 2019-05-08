package com.kalavakuri.webmvc.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan
public class SpringMVCConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {

		ViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasename("classpath:webmvc");
		return reloadableResourceBundleMessageSource;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
