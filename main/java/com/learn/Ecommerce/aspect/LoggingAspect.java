package com.learn.Ecommerce.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect

public class LoggingAspect {
	@Before("execution(* com.learn.Ecommerce.service.UserService.getAllUsers(..))")
	public void log()
	{
		System.out.println("Aspect log is called");
	}

}
