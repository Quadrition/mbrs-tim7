package ${class.typePackage};

import java.util.List;
import java.util.Date;

public class ${class.name}Mapper {

	public static ${class.name}DTO toDto(${class.name} entity){
		${class.name}DTO retVal = new ${class.name}DTO();
		<#list properties as property>
			<#if property.upper == 1>
				<#if property.association == false>
		retVal.set${property.name?cap_first}(entity.get${property.name?cap_first}());
				<#else>
		retVal.set${property.name?cap_first}(${property.type?cap_first}Mapper.toDto(entity.get${property.name?cap_first}()));
				</#if>
			<#else>
		retVal.set${property.name?cap_first}(${property.type?cap_first}Mapper.toDtoList(entity.get${property.name?cap_first}()))
			</#if>
		</#list>
		return retVal;
	}
	
	public static ${class.name} toEntity(${class.name}DTO dto) {
		${class.name} retVal = new ${class.name}();
		<#list properties as property>
			<#if property.upper == 1>
				<#if property.association == false>
		retVal.set${property.name?cap_first}(dto.get${property.name?cap_first}());
				<#else>
		retVal.set${property.name?cap_first}(${property.type?cap_first}Mapper.toEntity(dto.get${property.name?cap_first}()));
				</#if>
			<#else>
		retVal.set${property.name?cap_first}(${property.type?cap_first}Mapper.toEntityList(dto.get${property.name?cap_first}()))
			</#if>
		</#list>
		return retVal;
	}
	
	public static List<${class.name}> toEntityList(List<${class.name}DTO> dtos) {
	
	 	List<${class.name}> retVal = new ArrayList<${class.name}>();
		for(${class.name}DTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static List<${class.name}DTO> toDtoList(List<${class.name}> entities){
	
		List<${class.name}DTO> retVal = new ArrayList<${class.name}DTO>();
			for(${class.name} entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}