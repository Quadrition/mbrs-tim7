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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/library")
public class LibraryController {  

	@Autowired
	private LibraryService libraryService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<ArrayList<LibraryDTO>> getLibraryList () {

		List<Library> libraryList = libraryService.findAll();
	
		return new ResponseEntity<>(LibraryMapper.toDtoList(libraryList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<LibraryDTO> getLibrary(@PathVariable Long id) {
		Library library = libraryService.findOne(id);
		if (library == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(LibraryMapper.toDto(library), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LibraryDTO> add(@RequestBody @Valid LibraryDTO newLibrary) {

		Library savedLibrary = libraryService.save(newLibrary);

		return new ResponseEntity<>(LibraryMapper.toDto(savedLibrary), HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<LibraryDTO> edit(@RequestBody @Valid LibraryDTO library, @PathVariable Long id) {

		if (id != library.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Library persisted;
		try {
			persisted = libraryService.update(library);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(LibraryMapper.toDto(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<LibraryDTO> delete(@PathVariable Long id) {
		Library deleted;
		try {
			deleted = libraryService.remove(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		

		return new ResponseEntity<>(LibraryMapper.toDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByName/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<LibraryDTO>> getLibraryListByName(@PathVariable String  value) {

		List<Library> libraryList = libraryService.findByName(value);
			
		return new ResponseEntity<>(LibraryMapper.toDtoList(libraryList), HttpStatus.OK);
	}

}