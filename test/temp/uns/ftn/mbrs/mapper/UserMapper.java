package uns.ftn.mbrs.mapper;

import java.util.List;
import java.util.Date;

public class UserMapper {

	public static UserDTO toDto(User entity){
		UserDTO retVal = new UserDTO();
		retVal.setFirstName(entity.getFirstName());
		retVal.setLastName(entity.getLastName());
		retVal.setLibrary(Myplugin.generator.fmmodel.FMType@4976465cMapper.toDto(entity.getLibrary()));
		return retVal;
	}
	
	public static User toEntity(UserDTO dto) {
		User retVal = new User();
		retVal.setFirstName(dto.getFirstName());
		retVal.setLastName(dto.getLastName());
		retVal.setLibrary(Myplugin.generator.fmmodel.FMType@4976465cMapper.toEntity(dto.getLibrary()));
		return retVal;
	}
	
	public static List<User> toEntityList(List<UserDTO> dtos) {
	
	 	List<User> retVal = new ArrayList<User>();
		for(UserDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static List<UserDTO> toDtoList(List<User> entities){
	
		List<UserDTO> retVal = new ArrayList<UserDTO>();
			for(User entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}