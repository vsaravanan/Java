package java4s;
import com.opensymphony.xwork2.ActionSupport;

public class LogingEx extends ActionSupport{	
	private static final long serialVersionUID = 1L;
	
	private MyBean beanobject;
	
	
	public MyBean getBeanobject() {
		return beanobject;
	}

	public void setBeanobject(MyBean beanobject) {
		this.beanobject = beanobject;
	}


	public String execute()
	{		
		return SUCCESS;
	}
	
	
}
