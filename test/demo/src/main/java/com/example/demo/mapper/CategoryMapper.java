package com.example.demo.mapper;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.ArrayList;
import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

public class CategoryMapper {

	public static CategoryDTO toDto(Category entity){
		CategoryDTO retVal = new CategoryDTO();
		retVal.setName(entity.getName());
		retVal.setDescription(entity.getDescription());
		return retVal;
	}
	
	public static Category toEntity(CategoryDTO dto) {
		Category retVal = new Category();
		retVal.setName(dto.getName());
		retVal.setDescription(dto.getDescription());
		return retVal;
	}
	
	public static ArrayList<Category> toEntityList(List<CategoryDTO> dtos) {
	
	 	ArrayList<Category> retVal = new ArrayList<Category>();
		for(CategoryDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static ArrayList<CategoryDTO> toDtoList(List<Category> entities){
	
		ArrayList<CategoryDTO> retVal = new ArrayList<CategoryDTO>();
			for(Category entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}