package com.ibm.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenBreweryController {

	@Autowired
	OpenBreweryClient breweryClient;
	
	@RequestMapping(value = "/allBreweries", method = RequestMethod.GET)
	String allBreweries() {
		return breweryClient.getBreweries();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	String aBrewery(@PathVariable Integer id) {
		return breweryClient.getABrewery(id);
	}
	
	@RequestMapping(value= "/autocomplete", method = RequestMethod.GET)
	String autocompleteBrewery(@RequestParam(value = "query", defaultValue = "dog") String reference) {
		return breweryClient.getAutoComplete(reference);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	String searchBrewery(@RequestParam(value = "query", defaultValue = "dog") String reference) {
		return breweryClient.getSearch(reference);
	}
}
