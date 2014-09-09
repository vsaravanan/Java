<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
<html>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <s:head />
</head>
    
<body>


<s:form  action="verify"   >

	<s:textfield name="name" key="name" required="true"/><br>
	<s:textfield name="age" key="age" required="true"/><br>
	<s:textfield name="email" key="email" required="true"/><br>
     
    <s:submit method="addEmployee" key="label.add.employee" align="center" /> 



</s:form>
</body>
</html>