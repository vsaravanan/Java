Struts 2.3

Struts2Interceptor

It shows the alternative way of using simple html tags and without using struts tags.
but you still want to send request parameters to the action class.
It is possible by implementing params interceptor.
Interceptor Params: It populates the action properties with the request parameters.
Please take a look  <interceptor-ref name="params"/>
and take look at index.jsp
  
just simple html tags are used as below
   <form action="hello">
      <label for="name">Please enter your name</label><br/>
      <input type="text" name="name"/>
      <input type="submit" value="Say Hello"/>
   </form>
it is not used with struts based html tags as below
	<s:form action="hello">
		<s:label for="name" value="Please enter your name"/><br/>
		<s:textfield key="Your Name" name="name"/>
		<s:submit value="Say Hello"/>
	</s:form>

courtesy : http://www.dineshonjava.com/2013/07/struts-2-interceptors.html

Test site : http://saravan.asuscomm.com/Struts2Interceptor/


