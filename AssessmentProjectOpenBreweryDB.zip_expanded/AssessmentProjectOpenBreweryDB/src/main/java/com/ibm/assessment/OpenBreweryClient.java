package com.ibm.assessment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class OpenBreweryClient {

	@Value("${rapidapi.openbrewery.url}")
	String openBreweryURL;
	
	@Value("${rapidapi.key.name}")
	String openBreweryKeyName;
	
	@Value("${rapidapi.key.valu}")
	String openBreweryKeyValue;
	
	@Value("${rapidapi.host.name}")
	String openBreweryHostName;
	
	@Value("${rapidapi.host.openbrewery.value}")
	String openBreweryHostValue;
	
	public String getBreweries(){
		try {
			HttpResponse<String> response = Unirest.get(openBreweryURL + "?by_state=NY&by_name=cooper&by_tag=patio&by_type=micro")
					.header(openBreweryHostName, openBreweryHostValue)
					.header(openBreweryKeyName, openBreweryKeyValue)
					.asString();
			return (response.getBody());
		}catch(UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getABrewery(Integer id) {
		try {
			HttpResponse<String> response = Unirest.get(openBreweryURL + id)
					.header(openBreweryHostName, openBreweryHostValue)
					.header(openBreweryKeyName, openBreweryKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAutoComplete(String reference) {
		try {
			HttpResponse<String> response = Unirest.get(openBreweryURL + "/autocomplete?query="+ reference)
					.header(openBreweryHostName, openBreweryHostValue)
					.header(openBreweryKeyName, openBreweryKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getSearch(String reference) {
		try {
			HttpResponse<String> response = Unirest.get(openBreweryURL + "/search?query=" + reference)
					.header(openBreweryHostName, openBreweryHostValue)
					.header(openBreweryKeyName, openBreweryKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

























