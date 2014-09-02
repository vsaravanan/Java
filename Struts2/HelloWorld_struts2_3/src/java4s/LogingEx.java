package java4s;
import com.opensymphony.xwork2.ActionSupport;
public class LogingEx extends ActionSupport{	
	private static final long serialVersionUID = 1L;
	
	private String uname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	
	public String execute()
	{		
		if(uname.equals("java4s"))
		{
			return SUCCESS;
			
		}else 
			return ERROR;
	}
	
	
}
