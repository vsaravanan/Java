<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

   <s:form >
   <s:radio label="Gender" name="gender" list="{'male','female'}" />
   <s:checkboxlist label="Job Types" name="jobtypes"
   list="{'Software','Hardware','Networking','Marketing'}" />
   </s:form>