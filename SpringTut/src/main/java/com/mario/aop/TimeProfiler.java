package com.mario.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by raqsW on 2016-08-26.
 */
@Aspect
@Component
public class TimeProfiler {
	private static final Logger logger = Logger.getLogger(TimeProfiler.class);

	@Pointcut("execution(public * *(..))")
	public void anyPublicOperation() {
	}

	@Around( value = "anyPublicOperation() && @annotation(com.mario.aop.Profiled)" )
	public Object executionTime(ProceedingJoinPoint pjp)  throws Throwable {
		StopWatch clock = new StopWatch( "Profiling for '" + pjp.getSignature().getName() + "'" );
		try {
			clock.start( pjp.toShortString() );
			return pjp.proceed();
		}
		finally {
			clock.stop();
			logger.info( clock.prettyPrint() );
		}
	}
}
