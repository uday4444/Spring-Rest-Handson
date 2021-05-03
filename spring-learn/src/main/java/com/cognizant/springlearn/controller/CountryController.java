package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.model.CountryList;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value = "/country")
	public Country getCountryIndia()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country	country = (Country) context.getBean("country",Country.class);
		return country;
		
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList	country = (CountryList) context.getBean("countryList",CountryList.class);
		return country.getCountryList();
	}
	
	@GetMapping(value = "/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		
		return countryService.getCountry(code);
	}

	
	
}
