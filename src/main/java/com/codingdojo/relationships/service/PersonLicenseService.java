package com.codingdojo.relationships.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;


@Service
public class PersonLicenseService {
		private final PersonRepository personRepo;
		private final LicenseRepository licenseRepo;

		public PersonLicenseService (PersonRepository personRepo, LicenseRepository licenseRepo) {
			this.personRepo= personRepo;
			this.licenseRepo=licenseRepo;
			}
		
		public ArrayList<Person> allPersons(){
			return personRepo.findAll();
			}

		public Person createPerson(Person p) {
			return personRepo.save(p);
		}
		public Person findPerson(Long id) {
			Optional<Person> optionalPerson = personRepo.findById(id);
			if(optionalPerson.isPresent()) {
				return optionalPerson.get();
			} else {
				return null;
			}
		}
		public ArrayList<License> allLicense(){
			return licenseRepo.findAll();
		}
		public License createLicense(License l) {
			return licenseRepo.save(l);
		}
		public License findLicense(Long id) {
			Optional<License> optionalLicense = licenseRepo.findById(id);
			if(optionalLicense.isPresent()) {
				return optionalLicense.get();
			} else {
				return null;
			}
		}
}
