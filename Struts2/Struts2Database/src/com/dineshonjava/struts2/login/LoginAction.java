package com.dineshonjava.struts2.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Dinesh Rajput
 *
 */
@SuppressWarnings("serial")
public class LoginAction  extends ActionSupport{
	private String username;
    private String password;
    private String userid;
    
	public String execute() {
		String ret = ERROR;
	      Connection conn = null;
	      System.out.println("Struts2Database entered..");
	      try {
	         String URL = "jdbc:mysql://localhost:3306/test";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "rootpwd");
	         String sql = "SELECT UserName FROM users WHERE";
	         sql+=" UserName = ? AND PASSWORD = ?";
	         System.out.println(sql);
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, username);
	         ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();
	         
	         while (rs.next()) {
	        	 username = rs.getString(1);
	        	 ret = SUCCESS;
	         }
	      } catch (Exception e) {
	         ret = ERROR;
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      if ( ret.equalsIgnoreCase(ERROR))
	    	  addActionError(MessageFormat.format(getText("error.login"), username, password));  

	      return ret;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
 
}
