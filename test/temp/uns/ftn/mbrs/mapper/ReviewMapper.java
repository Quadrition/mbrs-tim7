package uns.ftn.mbrs.mapper;

import java.util.List;
import java.util.Date;

public class ReviewMapper {

	public static ReviewDTO toDto(Review entity){
		ReviewDTO retVal = new ReviewDTO();
		retVal.setBook(Myplugin.generator.fmmodel.FMType@6d224ba3Mapper.toDto(entity.getBook()));
		retVal.setComment(entity.getComment());
		return retVal;
	}
	
	public static Review toEntity(ReviewDTO dto) {
		Review retVal = new Review();
		retVal.setBook(Myplugin.generator.fmmodel.FMType@6d224ba3Mapper.toEntity(dto.getBook()));
		retVal.setComment(dto.getComment());
		return retVal;
	}
	
	public static List<Review> toEntityList(List<ReviewDTO> dtos) {
	
	 	List<Review> retVal = new ArrayList<Review>();
		for(ReviewDTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static List<ReviewDTO> toDtoList(List<Review> entities){
	
		List<ReviewDTO> retVal = new ArrayList<ReviewDTO>();
			for(Review entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}