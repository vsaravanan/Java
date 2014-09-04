<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<title>Ajax Tag Struts2 | dineshonjava.com</title>
<s:head />
<sx:head />
</head>
<body>
   <s:form>
      <sx:autocompleter label="Favourite Colour"
         list="{'red','green','blue'}" />
      <br />
      <sx:datetimepicker name="deliverydate" label="Delivery Date"
         displayFormat="dd/MM/yyyy" />
      <br />
      <s:url id="url1" value="/count1" />
      <s:url id="url2" value="/count2" />
      <s:url id="url3" value="/count3" />
      <sx:div href="%{#url3}" delay="2000">
           Initial Content
      </sx:div>
      <br/>
      <sx:tabbedpanel id="tabContainer">
         <sx:div label="Tab 1" href="%{#url1}">Tab 1</sx:div>
         <sx:div label="Tab 2" href="%{#url2}">Tab 2</sx:div>
      </sx:tabbedpanel>
   </s:form>
</body>
</html>