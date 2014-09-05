package com.dineshonjava.struts2.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Dinesh Rajput
 *
 */
public class MyInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation)throws Exception{

	      /* let us do some pre-processing */
	      String output = "Pre-Processing"; 
	      System.out.println(output);

	      /* let us call action or next interceptor */
	      String result = invocation.invoke();

	      /* let us do some post-processing */
	      output = "Post-Processing"; 
	      System.out.println(output);

	      return result;
	   }

}
