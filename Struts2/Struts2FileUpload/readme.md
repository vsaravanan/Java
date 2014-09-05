Struts 2.3

Struts2FileUpload

<pre>
   &lt;package name="upload" extends="struts-default"&gt;
      &lt;action name="userImage" class="com.dineshonjava.struts2.action.upload.FileUploadAction"&gt;
	  	  &lt;interceptor-ref name="fileUpload"&gt;
	        &lt;param name="maximumSize"&gt;2097152&lt;/param&gt;
	        &lt;param name="allowedTypes"&gt;
	            image/png,image/gif,image/jpeg,image/pjpeg
	        &lt;/param&gt;
	      &lt;/interceptor-ref&gt;
	      &lt;interceptor-ref name="defaultStack" /&gt;
		  &lt;result name="success"&gt;success.jsp&lt;/result&gt;
		  &lt;result name="input"&gt;index.jsp&lt;/result&gt;
		   &lt;result name="error"&gt;error.jsp&lt;/result&gt;
	&lt;/action&gt;
   &lt;/package&gt;
</pre>

courtesy : http://www.dineshonjava.com/2013/07/struts-2-file-upload-example.html

Test site : http://saravan.asuscomm.com/Struts2FileUpload/


