<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Address</title>
</head>
<body>
	Name : <bean:write name="addressForm" property="name"/><br/>
	Street : <bean:write name="addressForm" property="street" ignore="true"/><br/>
	City : <bean:write name="addressForm" property="city"/><br/>
	Country : <bean:write name="addressForm" property="country" ignore="true"/><br/>
	Pin : <bean:write name="addressForm" property="pin"/><br/>
</body>
</html>