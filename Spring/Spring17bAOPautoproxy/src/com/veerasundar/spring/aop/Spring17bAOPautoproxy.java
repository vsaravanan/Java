package com.veerasundar.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring17bAOPautoproxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Business bc = (Business) context.getBean("myBusinessClass");
		bc.doSomeOperation();
	}

}
