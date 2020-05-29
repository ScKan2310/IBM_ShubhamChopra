package com.ibm.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://localhost:3000/")
@RestController
public class OpenBreweryController {

	@Autowired
	OpenBreweryClient breweryClient;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	String aBrewery(@PathVariable Integer Id) {
		return breweryClient.getABrewery(Id);
	}
}
