package com.triarq.practice;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.triarq.practice.dao.PersonDao;
import com.triarq.practice.entity.Person;

@SpringBootApplication
public class JpaHibernatePracticeApplication implements CommandLineRunner {
	
	@Autowired
	private PersonDao personDao;
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernatePracticeApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		logger.info("All person details ->{}", personDao.findAll());
		//logger.info("Person detail of ID 10004 ->{}", personDao.findById(10004));
		logger.info("Person detail of ID 10004 ->{}", personDao.getById(10004));
		logger.info("Person detail by Name ->{}", personDao.findByName("ram"));
		//logger.info("Deleted Id is ->{}", personDao.deleteById(101));
	    logger.info("Insert the record 1213->{}", personDao.insertPerson(new Person(101, "rishikesh", "karnataka",formatter.parse("17-12-1997"))));
		//logger.info("Insert the record 1213->{}", personDao.insertPerson(new Person(1213, xyz, karnataka, new Date())));

	}
	
	

}
