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
		retVal.setLibrary(LibraryMapper.toDto(entity.getLibrary()));
		retVal.setCategory(CategoryMapper.toDto(entity.getCategory()));
		retVal.setReviews(ReviewMapper.toDtoList(entity.getReviews()));
		retVal.setTitle(entity.getTitle());
		retVal.setYear(entity.getYear());
		retVal.setAgeRecommendation(entity.getAgeRecommendation());
		return retVal;
	}
	
	public static Book toEntity(BookDTO dto) {
		Book retVal = new Book();
		retVal.setLibrary(LibraryMapper.toEntity(dto.getLibrary()));
		retVal.setCategory(CategoryMapper.toEntity(dto.getCategory()));
		retVal.setReviews(ReviewMapper.toEntityList(dto.getReviews()));
		retVal.setTitle(dto.getTitle());
		retVal.setYear(dto.getYear());
		retVal.setAgeRecommendation(dto.getAgeRecommendation());
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