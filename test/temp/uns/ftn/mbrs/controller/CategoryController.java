package uns.ftn.mbrs.controller;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;


import uns.ftn.mbrs.model.Category;
import uns.ftn.mbrs.service.CategoryService;
import uns.ftn.mbrs.converter.CategoryDTOToCategory;
import uns.ftn.mbrs.converter.CategoryToCategoryDTO;
import uns.ftn.mbrs.dto.CategoryDTO;

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
	
	@Autowired
	private CategoryToCategoryDTO toDTO;
	
	@Autowired
	private CategoryDTOToCategory toCategory;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<CategoryDTO>> getCategoryList () {

		List<Category> categoryList = categoryService.findAll();
	
		return new ResponseEntity<>(toDTO.convert(categoryList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
		Category category = categoryService.findOne(id);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(category), HttpStatus.OK);
	}
	

	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CategoryDTO> add(@RequestBody @Valid CategoryDTO newCategory) {

		Category savedCategory = categoryService.save(toCategory.convert(newCategory));

		return new ResponseEntity<>(toDTO.convert(savedCategory), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<CategoryDTO> edit(@RequestBody @Valid CategoryDTO category, @PathVariable Long id) {

		if (id != category.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Category persisted = categoryService.save(toCategory.convert(category));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<CategoryDTO> delete(@PathVariable Long id) {
		Category deleted = categoryService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByName/{value}", method = RequestMethod.GET)
	ResponseEntity<List<CategoryDTO>> getCategoryListByName(@PathVariable String  value) {

		List<Category> categoryList = categoryService.findByName(value);
			
		return new ResponseEntity<>(toDTO.convert(categoryList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByDescription/{value}", method = RequestMethod.GET)
	ResponseEntity<List<CategoryDTO>> getCategoryListByDescription(@PathVariable String  value) {

		List<Category> categoryList = categoryService.findByDescription(value);
			
		return new ResponseEntity<>(toDTO.convert(categoryList), HttpStatus.OK);
	}

}