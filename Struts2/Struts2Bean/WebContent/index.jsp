<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>

<s:form action="verify">

	<s:textfield name="beanobject.uname" label="Enter Username" /><br>
	<s:textfield name="beanobject.age" label="Enter Age" /><br>
	<s:textfield name="beanobject.sex" label="sex" /><br>
     
    <s:submit value="Click" align="center" /> 



</s:form>
</body>
</html>