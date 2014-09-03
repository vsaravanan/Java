<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="next">
Name:<s:property value="#session.a" /><br>
Age:<s:property value="#session.b" /> 
<s:submit value="next" />
</s:form>
