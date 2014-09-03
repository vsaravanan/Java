package java4s;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class NextActions extends ActionSupport implements SessionAware{	
	
	Map m;	
	
    public void setSession(Map m)
    {
    	this.m=m;
    }

	public String execute()
	{			
		return SUCCESS;
	}
	
	
}
