package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;



import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/book")
public class BookController {  

	@Autowired
	@Qualifier("bookServiceImpl")
	private BookService bookService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<ArrayList<BookDTO>> getBookList () {

		List<Book> bookList = bookService.findAll();
	
		return new ResponseEntity<>(BookMapper.toDtoList(bookList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
		Book book = bookService.findOne(id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(BookMapper.toDto(book), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BookDTO> add(@RequestBody @Valid BookDTO newBook) {

		Book savedBook = bookService.save(newBook);

		return new ResponseEntity<>(BookMapper.toDto(savedBook), HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<BookDTO> edit(@RequestBody @Valid BookDTO book, @PathVariable Long id) {

		if (id != book.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Book persisted;
		try {
			persisted = bookService.update(book);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(BookMapper.toDto(persisted), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/filterByTitle/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<BookDTO>> getBookListByTitle(@PathVariable String  value) {

		List<Book> bookList = bookService.findByTitle(value);
			
		return new ResponseEntity<>(BookMapper.toDtoList(bookList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByYear/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<BookDTO>> getBookListByYear(@PathVariable int  value) {

		List<Book> bookList = bookService.findByYear(value);
			
		return new ResponseEntity<>(BookMapper.toDtoList(bookList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByAgeRecommendation/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<BookDTO>> getBookListByAgeRecommendation(@PathVariable Age  value) {

		List<Book> bookList = bookService.findByAgeRecommendation(value);
			
		return new ResponseEntity<>(BookMapper.toDtoList(bookList), HttpStatus.OK);
	}

}