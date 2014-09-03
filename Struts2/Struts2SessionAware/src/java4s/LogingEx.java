package java4s;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogingEx extends ActionSupport implements SessionAware{	
	private static final long serialVersionUID = 1L;
	
	private String stuname,stuage,country;
	private int stumarks;	
	Map m;
		
	
	
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	
	public String getStuage() {
		return stuage;
	}
	public void setStuage(String stuage) {
		this.stuage = stuage;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public int getStumarks() {
		return stumarks;
	}
	public void setStumarks(int stumarks) {
		this.stumarks = stumarks;
	}
  
    public void setSession(Map m)
    {
    	this.m=m;
    }


	public String execute()
	{	
		m.put("a",stuname);
		m.put("b", stuage);
		m.put("c",stumarks);
		m.put("d",country);
		
		return SUCCESS;
	}
	
	
}
