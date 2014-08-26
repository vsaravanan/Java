package org.krams.tutorial.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Address. 
 */
@Service("addressService")
@Transactional
public class AddressService {

	protected static Logger logger = Logger.getLogger("service");
	
	/**
	 * Retrieves all available addresses
	 * 
	 * @return list of addresses
	 */
	public List<Address> getAll() {
		logger.debug("Retrieving all addresses");
		
		// Create an in-memory list of addresses
		// You can instead retrieve the data from a database
		List<Address> addresses = new ArrayList<Address>();
		
		// New address
		Address address = new Address();
		address.setId(1);
		address.setStreet("1 Street");
		address.setCity("City 1");
		address.setZipCode("11111");
		
		// Add to list
		addresses.add(address);
		
		// New address
		address = new Address();
		address.setId(2);
		address.setStreet("2 Street");
		address.setCity("City 2");
		address.setZipCode("22222");
		
		// Add to list
		addresses.add(address);
		
		// New address
		address = new Address();
		address.setId(3);
		address.setStreet("3 Street");
		address.setCity("City 3");
		address.setZipCode("33333");
		
		// Add to list
		addresses.add(address);
		
		// Return all addresses
		return addresses;
	}
}
