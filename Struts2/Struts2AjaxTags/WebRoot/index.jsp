<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<title>Form Tag Struts2 | dineshonjava.com</title>
</head>
<body>
   <s:div>Email Form</s:div>
   <s:text name="Please fill in the form below:" />
   <s:form action="ajaxtag" method="post" enctype="multipart/form-data">
   <s:hidden name="secret" value="abracadabra"/>
   <s:textfield key="email.from" name="from" />
   <s:password key="email.password" name="password" />
   <s:textfield key="email.to" name="to" />
   <s:textfield key="email.subject" name="subject" />
   <s:textarea key="email.body" name="emailbody" />
   <s:label for="attachment" value="Attachment"/>
   <s:file name="attachment" accept="text/html,text/plain" />
   <s:token />
   <s:submit key="submit" />
   </s:form>
</body>
</html>