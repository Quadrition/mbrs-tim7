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
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookReposiroty;
	
	@Autowired
	private UserRepository userReposiroty;
	
	@Override
	public Library findOne(Long id){
		return libraryRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Library> findAll(){
		return libraryRepository.findAll();
	}
	
	@Override
	public List<Library> findByName(String name){
		return libraryRepository.findByName(name);
	}

	@Override
	public Library save(LibraryDTO library){
		Library newEntity = new Library();
		newEntity.setName(library.getName());
		// asocijacija bookReposiroty		
		// asocijacija userReposiroty		
		
		return libraryRepository.save(newEntity);
	}
	@Override
	public Library update(LibraryDTO library) throws Exception{
		Library existing = libraryRepository.findById(library.getId()).orElse(null);
		if(existing == null){
			throw new Exception("Library doesn't exist");
		}
		//update entity
		existing.setName(library.getName());
		// asocijacija bookRepository				
		// asocijacija userRepository				
		
		return libraryRepository.save(existing);
	}
	@Override
	public Library remove(Long id)  throws Exception{
		Library existing = libraryRepository.findById(id).orElse(null);
		if(existing == null){
			throw new Exception("Library doesn't exist");
		}
		libraryRepository.delete(existing);
		
		return existing;
	}
}