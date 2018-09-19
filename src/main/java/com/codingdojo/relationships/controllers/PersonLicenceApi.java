package com.codingdojo.relationships.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.service.PersonLicenseService;
@RestController
public class PersonLicenceApi {

	private final PersonLicenseService plService;

	public PersonLicenceApi(PersonLicenseService plService) {
		this.plService=plService;
	}

	@RequestMapping("api/all")
	public ArrayList<Person> index(){
		return plService.allPersons();
	}
	@PostMapping("api/new")
	public Person create (
			@RequestParam(value="firstName") String name, 
			@RequestParam(value="lastName") String last) {
		Person person = new Person(name, last);
		return plService.createPerson(person);	
	}
	@RequestMapping("api/{id}")
	public Person show(@PathVariable("id") Long id) {
		Person person = plService.findPerson(id);
		return person;
	}
	@RequestMapping("api/license")
	public ArrayList<License> index2() {
		return plService.allLicense();
    }
    
    @PostMapping(value="api/new/license")
    public License create(
    		@RequestParam(value="person") Long id,
    		@RequestParam(value="expiration_date") Date date, 
    		@RequestParam(value="state") String state ){
    	Person person = plService.findPerson(id);
        License license = new License(person, date, state);
        return plService.createLicense(license);
    }
    
    @RequestMapping("api/license/{id}")
    public License show2(@PathVariable("id") Long id) {
        License license = plService.findLicense(id);
        return license;
    }
}
