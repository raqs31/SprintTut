package com.mario.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by raqsW on 2016-08-26.
 */
@Aspect
@Component
public class TimeProfiler {
	private static final Logger logger = Logger.getLogger(TimeProfiler.class);

	@Around(value = "@annotation(com.mario.spring.aop.Profile)")
	public Object executionTime(ProceedingJoinPoint pjp)  throws Throwable {
		long time = System.nanoTime();
		Object ret = pjp.proceed();
		logger.info("Execution of " + pjp.getKind() + " time: " + ((System.nanoTime() - time) / 10e9));
		return ret;
	}
}
