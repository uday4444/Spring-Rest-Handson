package com.cognizant.springlearn.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountryList {
	
	private List<Country> countryList;

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryList.class);

	public CountryList() {
		super();
		LOGGER.debug("Inside CountryList Constructor");

	}
	@Override
	public String toString() {
		return "CountryList [countryList=" + countryList + "]";
	}

	public CountryList(List<Country> countryList) {
		super();
		this.countryList = countryList;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	
		

}
