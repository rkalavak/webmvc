package com.kalavakuri.webmvc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WelcomeControllerAspect {

	@Around("execution(* com.kalavakuri.webmvc.web.controller.WelcomeController.welcomePage(..)) && args(welcomeMessage)")
	public Object beforeWelcomePage(ProceedingJoinPoint proceedingJoinPoint, String welcomeMessage) throws Throwable {
		return proceedingJoinPoint.proceed(new Object[] { "Hello AOP!" });
	}
}
