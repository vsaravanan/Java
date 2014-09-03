package java4s;
import java.util.Date;


public class LogingEx {		
	private static final long serialVersionUID = 1L;
	
	private Date toDate;
	private Date fromDate;
	private Date otherDate;
	
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getOtherDate() {
		return otherDate;
	}
	public void setOtherDate(Date otherDate) {
		this.otherDate = otherDate;
	}
	
	  public String execute(){	 
	  return "success";
	  }  
	
}
