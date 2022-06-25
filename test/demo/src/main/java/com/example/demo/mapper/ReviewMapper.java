package com.example.demo.mapper;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.ArrayList;
import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

public class ReviewMapper {

	public static ReviewDTO toDto(Review entity){
		ReviewDTO retVal = new ReviewDTO();
		retVal.setBook(BookMapper.toDto(entity.getBook()));
		retVal.setComment(entity.getComment());
		return retVal;
	}
	
	public static Review toEntity(ReviewDTO dto) {
		Review retVal = new Review();
		retVal.setBook(BookMapper.toEntity(dto.getBook()));
		retVal.setComment(dto.getComment());
		return retVal;
	}
	
	public static ArrayList<Review> toEntityList(List<ReviewDTO> dtos) {
	
	 	ArrayList<Review> retVal = new ArrayList<Review>();
		for(ReviewDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static ArrayList<ReviewDTO> toDtoList(List<Review> entities){
	
		ArrayList<ReviewDTO> retVal = new ArrayList<ReviewDTO>();
			for(Review entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}