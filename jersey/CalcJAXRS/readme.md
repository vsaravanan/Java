HOW TO CREATE A SIMPLE RESTFUL WEB SERVICE USING JERSEY JAX RS API


http://theopentutorials.com/examples/java-ee/jax-rs/create-a-simple-restful-web-service-using-jersey-jax-rs/


Test steps:

http://localhost:9999/calcrest/application.wadl

http://localhost:9999/calcrest/calc/add/20/30/

http://localhost:9999/calcrest/calc/sub/20/30/

Output :

Add Response: GET http://localhost:9999/calcrest/calc/add/122/34 returned a response status of 200 OK
Add Output as XML: <?xml version="1.0"?><result>156.0</result>
Add Output as Text: 156.0
---------------------------------------------------
Sub Response: GET http://localhost:9999/calcrest/calc/sub/122/34 returned a response status of 200 OK
Sub Output as XML: <?xml version="1.0"?><result>88.0</result>
---------------------------------------------------