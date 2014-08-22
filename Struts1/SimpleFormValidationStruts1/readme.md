Simple Form Validation with Struts 1 Example

http://www.raistudies.com/struts-1/simple-form-validation-with-struts-1-example/

For the fulfillment of the requirement, we have to do following steps:

First of all, we will create a form bean (AddressForm.java) which will overwrite validate method to apply validation rules in the specified field.
Then, we will create jsp page for the HTML form (AddressInput.jsp) which will take input from the user. This jsp page will also contain some new struts 1 taglibs for showing errors in validation process.
Next, we will implement a jsp page (ShowAddress.jsp) to show the address provided by the user.  This page will show to the user only if no validation error present in the form data.
Create a controller helper class (AddressAction.java) which will show the address provided by user in ShowAddress.jsp if no validation error exist otherwise show the address input form again with the error descriptions.
We will learn a new method of storing string values in properties file and show in the jsp page at run time. This facility is provided by struts1 by the use of “message-resources” configuration in struts-config.xml. We will use “MessageResources.properties” file to store validation error description and show them on AddressInput.jsp when a validation error will occur.
And finally, we will configure our struts 1 components in struts-config.xml configuration file.