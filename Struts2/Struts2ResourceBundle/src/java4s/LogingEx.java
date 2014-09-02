package java4s;
import com.opensymphony.xwork2.ActionSupport;

public class LogingEx extends ActionSupport{	
	private static final long serialVersionUID = 1L;
	
	private String uname,password;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute()
	{		
		if(uname.equals("java4s") && password.equals("pass"))
		{
			return SUCCESS;
			
		}else 
			this.addActionError(getText("u.p.wrong"));
		    return ERROR;
	}
	
	
	public void validate()
	{
		if(uname.equals("") || uname.length()==0)
			this.addFieldError("uname",getText("user.wrong"));
		if(password.equals("") || password.length()==0)
			this.addFieldError("password",getText("pass.wrong"));
		
	}
	
	
}
