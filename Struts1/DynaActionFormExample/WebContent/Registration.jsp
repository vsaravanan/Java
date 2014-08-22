<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	All Fields are mandatory :
	<html:form action="/registration">
		<table>
			<tr><td colspan="2"><html:errors/></td></tr>
			<tr><td>Name : </td><td><html:text property="name"/></td></tr>
			<tr><td>Username : </td><td><html:text property="username"/></td></tr>
			<tr><td>Password : </td><td><html:password property="password"/></td></tr>
			<tr><td>Retype Password : </td><td><html:password property="rePassword"/></td></tr>
			<tr><td colspan="2"><html:submit value="Register Me"/></tr>
		<table>
	</html:form>
</body>
</html>