package com.example.demo.mapper;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.ArrayList;
import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

public class UserMapper {

	public static UserDTO toDto(User entity){
		UserDTO retVal = new UserDTO();
		retVal.setFirstName(entity.getFirstName());
		retVal.setLastName(entity.getLastName());
		retVal.setLibrary(LibraryMapper.toDto(entity.getLibrary()));
		return retVal;
	}
	
	public static User toEntity(UserDTO dto) {
		User retVal = new User();
		retVal.setFirstName(dto.getFirstName());
		retVal.setLastName(dto.getLastName());
		retVal.setLibrary(LibraryMapper.toEntity(dto.getLibrary()));
		return retVal;
	}
	
	public static ArrayList<User> toEntityList(List<UserDTO> dtos) {
	
	 	ArrayList<User> retVal = new ArrayList<User>();
		for(UserDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static ArrayList<UserDTO> toDtoList(List<User> entities){
	
		ArrayList<UserDTO> retVal = new ArrayList<UserDTO>();
			for(User entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}