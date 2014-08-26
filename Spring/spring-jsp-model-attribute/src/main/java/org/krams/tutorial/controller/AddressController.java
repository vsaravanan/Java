package org.krams.tutorial.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Address;
import org.krams.tutorial.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and retrieves Addresses related requests.
 * <p>
 * This demonstrates how we can populate a JSP page using @ModelAttribute and Model
 */
@Controller
@RequestMapping("/address")
public class AddressController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="addressService")
	private AddressService addressService;
	
	/**
	 * Retrieves all addresses and allows them to be used as a model
	 * @return a model attribute containing addresses
	 */
	@ModelAttribute("addresses")
	public List<Address> getAllAddresses() {
		// Delegate to service
		return addressService.getAll();
	}
	
	/**
	 * Handles and retrieves a JSP page containing all addresses.
	 * We use the @ModelAttribute to pass the data to the view
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value="list1", method = RequestMethod.GET)
    public String getAllUsingModelAttribute() {
    	logger.debug("Received request to show all addresses page");
     
    	// No need to add the model here
    	// It has been automatically added when we used the @ModelAttribute annotation earlier
    	// The name of the ModelAttribute is "addresses". Your JSP should reference "addresses"
    	
    	// This will resolve to /WEB-INF/jsp/addressespage.jsp
    	return "addressespage";
	}
    
	/**
	 * Handles and retrieves a JSP page containing all addresses.
	 * We use the Model to pass the data to the view
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value="list2", method = RequestMethod.GET)
    public String getAllUsingModel(Model model) {
    	logger.debug("Received request to show all addresses page");
     
    	// Here we add the model manually
    	// This should give the same result with the extra greetings
    	// The name of the Model is "addresses". Your JSP should reference "addresses" as well
    	model.addAttribute("addresses", addressService.getAll());
    	model.addAttribute("greetings", "I came from Model not ModelAttribute");
    	
    	// This will resolve to /WEB-INF/jsp/addressespage.jsp
    	return "addressespage";
	}
   
}
