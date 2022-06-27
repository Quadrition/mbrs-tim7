package com.example.demo.mapper;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.ArrayList;
import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

public class BookMapper {

	public static BookDTO toDto(Book entity){
		BookDTO retVal = new BookDTO();
		retVal.setId(entity.getId());
		retVal.setCategory(CategoryMapper.toDto(entity.getCategory()));
		retVal.setTitle(entity.getTitle());
		retVal.setYear(entity.getYear());
		retVal.setAgeRecommendation(entity.getAgeRecommendation());
		retVal.setReviews(ReviewMapper.toDtoList(entity.getReviews()));
		return retVal;
	}
	
	public static Book toEntity(BookDTO dto) {
		Book retVal = new Book();
		retVal.setId(dto.getId());
		retVal.setCategory(CategoryMapper.toEntity(dto.getCategory()));
		retVal.setTitle(dto.getTitle());
		retVal.setYear(dto.getYear());
		retVal.setAgeRecommendation(dto.getAgeRecommendation());
		retVal.setReviews(ReviewMapper.toEntityList(dto.getReviews()));
		return retVal;
	}
	
	public static ArrayList<Book> toEntityList(List<BookDTO> dtos) {
	
	 	ArrayList<Book> retVal = new ArrayList<Book>();
		for(BookDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static ArrayList<BookDTO> toDtoList(List<Book> entities){
	
		ArrayList<BookDTO> retVal = new ArrayList<BookDTO>();
			for(Book entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}