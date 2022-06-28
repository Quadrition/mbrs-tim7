package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookExtendedService;

/*
This is an example of how to extend auto-generated controller
NOTE: Add annotation @Qualifier("bookServiceImpl") in BookController.java 
*/


@RestController
@RequestMapping(value="/api/bookExtended")
public class BookExtendedController extends BookController {
	
	@Autowired
	@Qualifier("bookExtendedServiceImpl")
	private BookExtendedService bookExtendedService;
	
	@RequestMapping(value = "/numOfBooksByYear/{value}", method = RequestMethod.GET)
	ResponseEntity<Integer> getNumbersOfBooksByYear(@PathVariable int  value) {

		int num = bookExtendedService.getNumbersOfBooksByYear(value);
			
		return new ResponseEntity<Integer>(num, HttpStatus.OK);
	}

}
