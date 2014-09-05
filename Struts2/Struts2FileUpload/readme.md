Struts 2.3

Struts2FileUpload

<textarea rows="20" cols="80">
<pre>
   <package name="upload" extends="struts-default">
      <action name="userImage" class="com.dineshonjava.struts2.action.upload.FileUploadAction">
	  	  <interceptor-ref name="fileUpload">
	        <param name="maximumSize">2097152</param>
	        <param name="allowedTypes">
	            image/png,image/gif,image/jpeg,image/pjpeg
	        </param>
	      </interceptor-ref>
	      <interceptor-ref name="defaultStack" />
		  <result name="success">success.jsp</result>
		  <result name="input">index.jsp</result>
		   <result name="error">error.jsp</result>
	</action>
   </package>
</pre>
</textarea>

courtesy : http://www.dineshonjava.com/2013/07/struts-2-file-upload-example.html

Test site : http://saravan.asuscomm.com/Struts2FileUpload/


