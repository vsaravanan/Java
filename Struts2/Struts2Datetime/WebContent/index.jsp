<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<head>
<sx:head/><title>not working in Struts2.3.16.3 try older versions Date Picker Example</title>
</head>
  
  <body>

  <s:form action="resultAction">
  
 <sx:datetimepicker label="Select From" name="toDate" displayFormat="MM-dd-yy"   />
 <sx:datetimepicker label="Select To" name="fromDate" displayFormat="MM-dd-yy" />
 <sx:datetimepicker label="Select Other" name="otherDate" displayFormat="MM-dd-yy"  />
 
 <s:submit value="Click" align="center" /> 
 
 </s:form>

  </body>
