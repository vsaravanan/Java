<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Provide Address Information</title>
</head>
<body>
	Provide address information bellow form :<br/>
	* marked fields are required 
	<html:form action="/varifyAddress">
		<div style="color: red;">
			<ol>
				<html:errors/>
			</ol>
		</div>
		<br/>
		Name : <html:text property="name"/>*<br/><br/>
		Street : <html:text property="street"/><br/><br/>
		City : <html:text property="city"/>*<br/><br/>
		Country : <html:text property="country"/><br/><br/>
		Pin : <html:text property="pin" maxlength="6"/>*<br/><br/>
		<html:submit value="Submit"/>
	</html:form>
</body>
</html>