package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;
import com.example.demo.repository.*;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LibraryRepository libraryReposiroty;
	
	@Autowired
	private CategoryRepository categoryReposiroty;
	
	@Autowired
	private ReviewRepository reviewReposiroty;
	
	@Override
	public Book findOne(Long id){
		return bookRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	@Override
	public List<Book> findByTitle(String title){
		return bookRepository.findByTitle(title);
	}
	@Override
	public List<Book> findByYear(int year){
		return bookRepository.findByYear(year);
	}
	@Override
	public List<Book> findByAgeRecommendation(Age ageRecommendation){
		return bookRepository.findByAgeRecommendation(ageRecommendation);
	}

	@Override
	public Book save(BookDTO book){
		Book newEntity = new Book();
		newEntity.setLibrary(libraryReposiroty.findById(book.getLibrary().getId()).orElse(null));	
		newEntity.setCategory(categoryReposiroty.findById(book.getCategory().getId()).orElse(null));	
		// asocijacija reviewReposiroty		
		newEntity.setTitle(book.getTitle());
		newEntity.setYear(book.getYear());
		newEntity.setAgeRecommendation(book.getAgeRecommendation());
		
		return bookRepository.save(newEntity);
	}
	@Override
	public Book update(BookDTO book) throws Exception{
		Book existing = bookRepository.findById(book.getId()).orElse(null);
		if(existing == null){
			throw new Exception("Book doesn't exist");
		}
		//update entity
		existing.setLibrary(libraryReposiroty.findById(book.getLibrary().getId()).orElse(null));	
		existing.setCategory(categoryReposiroty.findById(book.getCategory().getId()).orElse(null));	
		// asocijacija reviewRepository				
		existing.setTitle(book.getTitle());
		existing.setYear(book.getYear());
		existing.setAgeRecommendation(book.getAgeRecommendation());
		
		return bookRepository.save(existing);
	}
}