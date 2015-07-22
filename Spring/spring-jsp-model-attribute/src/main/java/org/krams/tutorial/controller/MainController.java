package org.krams.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Person;
import org.krams.tutorial.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and retrieves Person related requests
 */
@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="personService")
	private PersonService personService;
	
	/**
	 * Retrieves all persons and allows them to be used as a model
	 * @return a model attribute containing persons
	 */
	@ModelAttribute("persons") // mvs to set the modelattribute with data
	public List<Person> getAllPersons() {
		logger.debug("Retrieving all persons and adding it to ModelAttribute");
		
		// Delegate to PersonService
		return personService.getAll(); // mvs return model
	}
	
	/**
	 * Retrieves all currency types
	 * @return
	 */
	@ModelAttribute("currencies") // mvs to set the modelattribute with data
	public List<String> getAllCurrencies() {
		logger.debug("Retrieving all currencies and adding it to ModelAttribute");
		
		// Prepare data
		List<String> currencies = new ArrayList<String>();
		currencies.add("Dollar");
		currencies.add("Yen");
		currencies.add("Pound");
		currencies.add("Euro");
		currencies.add("Dinar");
		
		return currencies; // mvs return model 
	}
	
    @RequestMapping(method = RequestMethod.GET) // mvs fetching url
    public String getAllUsingModelAttribute() {
    	logger.debug("Received request to show all persons page");	
    	return "personspage"; // mvs return view name . model is not provided here. it is provided from modelattribute
	}    	
	
	/**
	 * Handles and retrieves a JSP page containing all persons
	 * 
	 * @return the name of the JSP page
	 */
//    @RequestMapping(method = RequestMethod.GET)
//    public String getAllPage(Model model) {
//    	logger.debug("Received request to show all persons page");
//    
//    	// The personspage.jsp referecences a model attribute named "persons"
//    	// We don't need to add the model here manually
//    	// It has been automatically added when we used @ModelAttribute("persons") earlier
//    	
//    	// This will resolve to /WEB-INF/jsp/personspage.jsp
//    	return "personspage";
//	}
//    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve person with matching id then add this person to the model
    	// The editpage.jsp references a model attribute named "personAttribute"
    	// So we add a "personAttribute" to the model.
    	// This "personAttribute" will be referenced again once we send the update form data
    	// We could have chosen a different name like "person" for the model
    	// If you do, make sure you update the JSP that references this name
    	// And update the POST method below that receives the request to do the actual update!
    	model.addAttribute("personAttribute", personService.get(id));
    	
    	// The editpage.jsp references a model attribute named "currencies"
    	// This model attribute is passed automatically when used @ModelAttribute("currencies") earlier
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "editpage";
	}
    
    /**
     * Saves the edited person and display all persons again
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person, 
    		@PathVariable Integer id, Model model) {
    	logger.debug("Received request to update person");
    
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	person.setId(id);
    	
    	// Delegate to PersonService for editing
    	// We show the all persons page again after updating the person
    	personService.edit(person);
    	
    	// The personspage.jsp referecences a model attribute named "persons"
    	// We don't need to add the model here manually
    	// It has been automatically added when we used @ModelAttribute("persons") earlier
    	
    	// However there's are two problems:
    	
    	// 1. The @ModelAttribute("persons") is called first before the actual update is performed.
    	// When the personspage is returned, the list of persons BEFORE
    	// the update is the list that will be retrieved.
    	// You will need to refresh the browser again to see the new list 
    	
    	// 2. You can try redirecting but you'll hit a known bug 
    	// See http://stackoverflow.com/questions/2163517/how-do-i-prevent-spring-3-0-mvc-modelattribute-variables-from-appearing-in-url
    	
    	// To avoid all that hassles, we just add the updated list of persons to the Model
    	// The "persons" attribute here is not the same with @ModelAttribute("persons")
    	// However, your JSP page references the same name so it won't care
    	model.addAttribute("persons", personService.getAll());
    	
    	// This will resolve to /WEB-INF/jsp/personspage.jsp
    	return "personspage";
	}
}
