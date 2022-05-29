package uns.ftn.mbrs.mapper;

import java.util.List;
import java.util.Date;

public class LibraryMapper {

	public static LibraryDTO toDto(Library entity){
		LibraryDTO retVal = new LibraryDTO();
		retVal.setName(entity.getName());
		retVal.setBooks(Myplugin.generator.fmmodel.FMType@204354ffMapper.toDtoList(entity.getBooks()))
		retVal.setUsers(Myplugin.generator.fmmodel.FMType@3e411332Mapper.toDtoList(entity.getUsers()))
		return retVal;
	}
	
	public static Library toEntity(LibraryDTO dto) {
		Library retVal = new Library();
		retVal.setName(dto.getName());
		retVal.setBooks(Myplugin.generator.fmmodel.FMType@204354ffMapper.toEntityList(dto.getBooks()))
		retVal.setUsers(Myplugin.generator.fmmodel.FMType@3e411332Mapper.toEntityList(dto.getUsers()))
		return retVal;
	}
	
	public static List<Library> toEntityList(List<LibraryDTO> dtos) {
	
	 	List<Library> retVal = new ArrayList<Library>();
		for(LibraryDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static List<LibraryDTO> toDtoList(List<Library> entities){
	
		List<LibraryDTO> retVal = new ArrayList<LibraryDTO>();
			for(Library entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}