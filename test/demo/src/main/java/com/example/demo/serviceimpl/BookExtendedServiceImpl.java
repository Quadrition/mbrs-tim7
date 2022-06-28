package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookExtendedService;


/*
This is an example of how to extend auto-generated service implementation
*/

@Service
@Qualifier("bookExtendedServiceImpl")
public class BookExtendedServiceImpl extends BookServiceImpl implements BookExtendedService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public int getNumbersOfBooksByYear(int year) {
		List<Book> books = bookRepository.findByYear(year);
		return books.size();
	}

}
