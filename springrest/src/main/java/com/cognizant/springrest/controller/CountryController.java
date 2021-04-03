package com.cognizant.springrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest.model.Country;
import com.cognizant.springrest.DAO.CountryList;
import com.cognizant.springrest.service.CountryService;
import com.cognizant.springrest.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/country")
	public Country getCountryIndia() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		return country;

	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList country = (CountryList) context.getBean("countryList", CountryList.class);
		return country.getCountryList();
	}

	@GetMapping(value = "/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

		return countryService.getCountry(code);
	}

	@PostMapping("/countries")
	public void addCountry(@RequestBody @Validated Country country) {
		countryService.addCountry(country);
		LOGGER.debug("Country:{}", country);
		LOGGER.info("After Adding Country");
		LOGGER.debug("List:{}", countryService.getAllCountries());

	}

}
