


	<aop:aspectj-autoproxy />
	
@Aspect
public class BusinessProfiler {

	@Pointcut("execution(* com.veerasundar.spring.aop.*.*(..))")
	public void businessMethods() {	}

	@Around("businessMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {

		Object output = pjp.proceed();

		return output;
	}

}
	