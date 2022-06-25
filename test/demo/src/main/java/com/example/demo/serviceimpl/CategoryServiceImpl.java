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
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findOne(Long id){
		return categoryRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	@Override
	public List<Category> findByName(String name){
		return categoryRepository.findByName(name);
	}
	@Override
	public List<Category> findByDescription(String description){
		return categoryRepository.findByDescription(description);
	}

	@Override
	public Category save(CategoryDTO category){
		Category newEntity = new Category();
		newEntity.setName(category.getName());
		newEntity.setDescription(category.getDescription());
		
		return categoryRepository.save(newEntity);
	}
	@Override
	public Category update(CategoryDTO category) throws Exception{
		Category existing = categoryRepository.findById(category.getId()).orElse(null);
		if(existing == null){
			throw new Exception("Category doesn't exist");
		}
		//update entity
		existing.setName(category.getName());
		existing.setDescription(category.getDescription());
		
		return categoryRepository.save(existing);
	}
	@Override
	public Category remove(Long id)  throws Exception{
		Category existing = categoryRepository.findById(id).orElse(null);
		if(existing == null){
			throw new Exception("Category doesn't exist");
		}
		categoryRepository.delete(existing);
		
		return existing;
	}
}