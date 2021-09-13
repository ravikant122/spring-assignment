package com.training.model.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	@Around("@annotation(com.training.model.service.MyLogging)")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object result =pjp.proceed();
		
		long end = System.currentTimeMillis();
		
		logger.info("method take " +pjp.getSignature()+ (end-start )+ " ms to execute");
		
		return result;
	}
}
