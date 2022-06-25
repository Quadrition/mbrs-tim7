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
@RequestMapping(value="/api/category")
public class CategoryController {  

	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<ArrayList<CategoryDTO>> getCategoryList () {

		List<Category> categoryList = categoryService.findAll();
	
		return new ResponseEntity<>(CategoryMapper.toDtoList(categoryList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
		Category category = categoryService.findOne(id);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(CategoryMapper.toDto(category), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CategoryDTO> add(@RequestBody @Valid CategoryDTO newCategory) {

		Category savedCategory = categoryService.save(newCategory);

		return new ResponseEntity<>(CategoryMapper.toDto(savedCategory), HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<CategoryDTO> edit(@RequestBody @Valid CategoryDTO category, @PathVariable Long id) {

		if (id != category.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Category persisted;
		try {
			persisted = categoryService.update(category);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(CategoryMapper.toDto(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<CategoryDTO> delete(@PathVariable Long id) {
		Category deleted;
		try {
			deleted = categoryService.remove(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		

		return new ResponseEntity<>(CategoryMapper.toDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByName/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<CategoryDTO>> getCategoryListByName(@PathVariable String  value) {

		List<Category> categoryList = categoryService.findByName(value);
			
		return new ResponseEntity<>(CategoryMapper.toDtoList(categoryList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByDescription/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<CategoryDTO>> getCategoryListByDescription(@PathVariable String  value) {

		List<Category> categoryList = categoryService.findByDescription(value);
			
		return new ResponseEntity<>(CategoryMapper.toDtoList(categoryList), HttpStatus.OK);
	}

}