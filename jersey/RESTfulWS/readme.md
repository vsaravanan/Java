RESTful Web Services with Java

http://java.dzone.com/articles/restful-web-services-java

REST stands for REpresentational State Transfer

 
Everything in REST is considered as a resource.
Every resource is identified by an URI.
Uses uniform interfaces. Resources are handled using POST, GET, PUT, DELETE operations 
Be stateless. Every request is an independent request. 
Communications are done via representations. E.g. XML, JSON

Run the webserver

try

http://localhost:8080/RESTfulWS/rest/UserInfoService/name/saravanan
 
	<?xml version="1.0"?>
	
	-<User>
	
	<Name>saravanan</Name>
	
	</User>
 

Run as Java application on UserInfoClient.java  
 
	Client Response 
	GET http://localhost:8080/RESTfulWS/rest/UserInfoService/name/Pavithra returned a response status of 200 OK
	Response 
	<User><Name>Pavithra</Name></User>
	
	
	Client Response 
	GET http://localhost:8080/RESTfulWS/rest/UserInfoService/age/25 returned a response status of 200 OK
	Response 
	<User><Age>25</Age></User>
	 