package uns.ftn.mbrs.mapper;

import java.util.List;
import java.util.Date;

public class BookMapper {

	public static BookDTO toDto(Book entity){
		BookDTO retVal = new BookDTO();
		retVal.setLibrary(Myplugin.generator.fmmodel.FMType@a15ccb5Mapper.toDto(entity.getLibrary()));
		retVal.setCategory(Myplugin.generator.fmmodel.FMType@454652e5Mapper.toDto(entity.getCategory()));
		retVal.setReviews(Myplugin.generator.fmmodel.FMType@7f98021eMapper.toDtoList(entity.getReviews()))
		retVal.setTitle(entity.getTitle());
		retVal.setYear(entity.getYear());
		retVal.setAgeRecommendation(entity.getAgeRecommendation());
		return retVal;
	}
	
	public static Book toEntity(BookDTO dto) {
		Book retVal = new Book();
		retVal.setLibrary(Myplugin.generator.fmmodel.FMType@a15ccb5Mapper.toEntity(dto.getLibrary()));
		retVal.setCategory(Myplugin.generator.fmmodel.FMType@454652e5Mapper.toEntity(dto.getCategory()));
		retVal.setReviews(Myplugin.generator.fmmodel.FMType@7f98021eMapper.toEntityList(dto.getReviews()))
		retVal.setTitle(dto.getTitle());
		retVal.setYear(dto.getYear());
		retVal.setAgeRecommendation(dto.getAgeRecommendation());
		return retVal;
	}
	
	public static List<Book> toEntityList(List<BookDTO> dtos) {
	
	 	List<Book> retVal = new ArrayList<Book>();
		for(BookDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static List<BookDTO> toDtoList(List<Book> entities){
	
		List<BookDTO> retVal = new ArrayList<BookDTO>();
			for(Book entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}