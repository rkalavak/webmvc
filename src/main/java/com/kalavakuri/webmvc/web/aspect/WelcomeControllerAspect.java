package com.kalavakuri.webmvc.web.aspect;

import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WelcomeControllerAspect {

	@Before("execution(* com.kalavakuri.webmvc.web.controller.WelcomeController.welcomePage(..)) && args(map)")
	public void beforeWelcomePage(Map<String, String> map) {
		map.put("Test", "Ramachandrappa Kalavakuri");
		System.out.println("Before welcomepage");
	}
}
