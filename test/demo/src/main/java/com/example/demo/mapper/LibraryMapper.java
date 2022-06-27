package com.example.demo.mapper;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.ArrayList;
import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

public class LibraryMapper {

	public static LibraryDTO toDto(Library entity){
		LibraryDTO retVal = new LibraryDTO();
		retVal.setId(entity.getId());
		retVal.setName(entity.getName());
		retVal.setBooks(BookMapper.toDtoList(entity.getBooks()));
		return retVal;
	}
	
	public static Library toEntity(LibraryDTO dto) {
		Library retVal = new Library();
		retVal.setId(dto.getId());
		retVal.setName(dto.getName());
		retVal.setBooks(BookMapper.toEntityList(dto.getBooks()));
		return retVal;
	}
	
	public static ArrayList<Library> toEntityList(List<LibraryDTO> dtos) {
	
	 	ArrayList<Library> retVal = new ArrayList<Library>();
		for(LibraryDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static ArrayList<LibraryDTO> toDtoList(List<Library> entities){
	
		ArrayList<LibraryDTO> retVal = new ArrayList<LibraryDTO>();
			for(Library entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}