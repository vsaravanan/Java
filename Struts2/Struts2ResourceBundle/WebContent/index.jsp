<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>

<s:actionerror/>
<s:form action="verify">

	<s:textfield name="uname" key="enter.user" /><br>
	<s:password name="password" key="enter.pass" /><br>
     
    <s:submit value="Click" align="center" /> 



</s:form>
</body>
</html>