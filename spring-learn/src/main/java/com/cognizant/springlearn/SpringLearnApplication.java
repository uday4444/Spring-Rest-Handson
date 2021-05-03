package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.model.CountryList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);

		//displayDate();
		//displayCountry();
		displayCountries();
		
	}

	public static void displayDate() throws ParseException {

		LOGGER.info("START");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date result = format.parse("31/12/2018");
		String date = String.valueOf(result);

		LOGGER.debug(date);
		// System.out.println(result);

		LOGGER.info("END");

	}

	public static void displayCountry() {
		LOGGER.info("Start of displayCountry method");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		
		LOGGER.debug("Country:{}", country.toString());
		
		LOGGER.debug("Another Country:{}",anotherCountry.toString());

		LOGGER.info("End of displayCountry method");
	}
	
	public static void displayCountries()
	{
		LOGGER.info("Start of displayCountries method");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList countries = (CountryList) context.getBean("countryList",CountryList.class);
		LOGGER.debug(countries.toString());
		LOGGER.info("End of displayCountries method");
		
	}
	

}
