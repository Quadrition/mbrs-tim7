package uns.ftn.mbrs.mapper;

import java.util.List;
import java.util.Date;

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
	
	public static List<Category> toEntityList(List<CategoryDTO> dtos) {
	
	 	List<Category> retVal = new ArrayList<Category>();
		for(CategoryDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static List<CategoryDTO> toDtoList(List<Category> entities){
	
		List<CategoryDTO> retVal = new ArrayList<CategoryDTO>();
			for(Category entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}