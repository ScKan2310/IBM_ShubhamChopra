package com.ibm.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OpenBreweryController {

	@Autowired
	OpenBreweryClient breweryClient;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/{id}")
	String aBrewery(@PathVariable String id) {
		return breweryClient.getABrewery(id);
	}
}
