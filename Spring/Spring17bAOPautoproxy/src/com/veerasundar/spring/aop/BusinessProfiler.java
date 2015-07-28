package com.veerasundar.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BusinessProfiler {

	@Pointcut("execution(* com.veerasundar.spring.aop.*.*(..))")
	public void businessMethods() {	}

	@Around("businessMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
			long start = System.currentTimeMillis();
			System.out.println("Going to call the method.");
		Object output = pjp.proceed();
			System.out.println("Method execution completed.");
			long elapsedTime = System.currentTimeMillis() - start;
			System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
		return output;
	}

}
