package com.codingdojo.relationships.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.service.PersonLicenseService;

@Controller

public class PersonLicenseController {
	private final PersonLicenseService pS;
	
	public PersonLicenseController(PersonLicenseService pS) {
		this.pS=pS;
	}
	@GetMapping("/")
	public String show(Model model) {
		ArrayList<Person> person = pS.allPersons();
		model.addAttribute("person", person);
		return "all.jsp";
	}
	@GetMapping("/person/new")
	public String create(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	@PostMapping("/person/new")
	public String create(@ModelAttribute("person") Person person, BindingResult res, Model model) {
		Person p= pS.createPerson(person);
		return "redirect:/";
	}
	@GetMapping("/person/{id}")
    public String show(@PathVariable ("id") Long id, Model model) {
    	Person p= pS.findPerson(id);
    	model.addAttribute("person", p);
    	return "show.jsp";
    }
	@RequestMapping("/person/license")
	public String add(Model model) {
		ArrayList<Person> person = pS.allPersons();
		model.addAttribute("person", person);
		return "license.jsp";
	}

	@PostMapping("/person/license")
	public String add(@ModelAttribute("person") Person person, @RequestParam("person") String per, @RequestParam("state") String state, @RequestParam("date") Date date) {
		Person p = pS.findPerson(Long.valueOf(per));
		License license = new License(p, date, state);
		license.setNumber("00000" + String.valueOf(p.getId()));
		p.setLicense(license);
		pS.createLicense(license);
		
//		Person p = pS.findPerson(id);
//		License l=pS.createLicense(license);
//		p.setLicense(license);
		return "redirect:/";
	}


}
