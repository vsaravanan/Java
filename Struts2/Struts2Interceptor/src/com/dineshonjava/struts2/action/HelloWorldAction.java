package com.dineshonjava.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Dinesh Rajput
 *
 */
public class HelloWorldAction extends ActionSupport {
	private static final long serialVersionUID = 4956157388836635122L;
	private String name;

	   public String execute() throws Exception {
		   System.out.println("name "+name);

		   if ("SECRET".equals(name))
	      {
	         return SUCCESS;
	      }else{
	         return ERROR;  
	      }
	   }  

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
}
