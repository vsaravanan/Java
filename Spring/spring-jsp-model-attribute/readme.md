Spring 3 MVC: Using @ModelAttribute or Model in Your JSPs
using @Controller, @Service, @RequestMapping, @Resource, component scan, annotation-driven, jstl

http://krams915.blogspot.sg/2010/12/spring-3-mvc-using-modelattribute-in.html

/main - retrieve all persons
/main/edit/{id} - (GET) retrieve and edit a person by his id 
/main/edit/{id} - (POST) save a person based on his id

http://localhost:8080/spring-jsp-model-attribute/krams/address/list1
http://localhost:8080/spring-jsp-model-attribute/krams/address/list2

http://localhost:8080/spring-jsp-model-attribute/krams/main/edit/2

Monitor the log msg from the web server
/*
 (MainController.java:getAllPersons:36) Retrieving all persons and adding it to ModelAttribute
 (PersonService.java:getAll:74) Retrieving all persons
 (MainController.java:getAllCurrencies:48) Retrieving all currencies and adding it to ModelAttribute
 (MainController.java:saveEdit:116) Received request to update person
 (PersonService.java:edit:102) Editing existing person
 (AddressService.java:getAll:26) Retrieving all addresses
 (AddressController.java:getAllUsingModelAttribute:48) Received request to show all addresses page
 (AddressService.java:getAll:26) Retrieving all addresses
 (AddressController.java:getAllUsingModel:66) Received request to show all addresses page
 (AddressService.java:getAll:26) Retrieving all addresses
*/