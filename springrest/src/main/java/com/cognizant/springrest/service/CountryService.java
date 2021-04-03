package com.cognizant.springrest.service;

import com.cognizant.springrest.DAO.CountryList;
import com.cognizant.springrest.model.Country;
import com.cognizant.springrest.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class CountryService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	CountryList countryListBean = (CountryList) context.getBean("countryList",CountryList.class);
	List<Country> countryList = countryListBean.getCountryList();
	
	public Country getCountry(String code) throws CountryNotFoundException
	{
			
		for(Country country : countryList)
		{	
			if(country.getCode().equalsIgnoreCase(code))
				return country;
			
		}
		
		throw new CountryNotFoundException("Country Not found");
		
	}
	
	public List<Country> getAllCountries()
	{
		return countryList;
	}
	
	public void addCountry(Country country)
	{
		LOGGER.info("Start of addCountry method");
		
		if(country!= null)
		{
			countryList.add(country);
		}
		LOGGER.info("End of addCountry method");
		
		
	}
	
}
