package com.cognizant.springlearn.service;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.model.CountryList;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	public Country getCountry(String code) throws CountryNotFoundException
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList countryList = (CountryList) context.getBean("countryList",CountryList.class);
		
		for(Country country : countryList.getCountryList())
		{	
			if(country.getCode().equalsIgnoreCase(code))
				return country;
			
		}
		
		throw new CountryNotFoundException("Country Not found");
		
	}
	
}
