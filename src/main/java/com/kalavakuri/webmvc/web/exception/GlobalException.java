package com.kalavakuri.webmvc.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = Throwable.class)
	public ModelAndView handleException(Throwable throwable) {

		ModelAndView modelAndView = new ModelAndView("GlobalException");

		return modelAndView;
	}
}
