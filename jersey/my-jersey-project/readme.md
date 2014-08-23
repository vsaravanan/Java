Rest using Jersey – Complete Tutorial with JAXB, Exception Handling and Client Program


http://www.journaldev.com/498/rest-using-jersey-complete-tutorial-with-jaxb-exception-handling-and-client-program

creating Restful web services and invoking the web service using Java client program and testing web service using tool. 
 
Run as web server

Then run as application from EmpClient
to see the results
you can change the id to 1 or 2 to see different results
        request.setId(1);
        


output for 1: Emp found

	200
	1::PK

output for 2: Emp not found
	
	500
	Wrong ID
	2




