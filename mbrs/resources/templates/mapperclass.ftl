package ${class.typePackage};

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.ArrayList;
<#assign mylist=class.typePackage?split(".")>
<#assign x=mylist?size-2>
<#assign baseDir=mylist[0]>
<#list 1..x as i>
	<#assign baseDir = baseDir+"."+mylist[i]>
</#list>
import ${baseDir}.model.*;
import ${baseDir}.service.*;
import ${baseDir}.mapper.*;
import ${baseDir}.dto.*;

public class ${class.name}Mapper {

	public static ${class.name}DTO toDto(${class.name} entity){
		${class.name}DTO retVal = new ${class.name}DTO();
		retVal.setId(entity.getId());
		<#list properties as property>
			<#if property.upper == 1>
				<#if property.association == false>
		retVal.set${property.name?cap_first}(entity.get${property.name?cap_first}());
				<#else>
		retVal.set${property.name?cap_first}(${property.type.name?cap_first}Mapper.toDto(entity.get${property.name?cap_first}()));
				</#if>
			<#else>
		retVal.set${property.name?cap_first}(${property.type.name?cap_first}Mapper.toDtoList(entity.get${property.name?cap_first}()));
			</#if>
		</#list>
		return retVal;
	}
	
	public static ${class.name} toEntity(${class.name}DTO dto) {
		${class.name} retVal = new ${class.name}();
		retVal.setId(dto.getId());
		<#list properties as property>
			<#if property.upper == 1>
				<#if property.association == false>
		retVal.set${property.name?cap_first}(dto.get${property.name?cap_first}());
				<#else>
		retVal.set${property.name?cap_first}(${property.type.name?cap_first}Mapper.toEntity(dto.get${property.name?cap_first}()));
				</#if>
			<#else>
		retVal.set${property.name?cap_first}(${property.type.name?cap_first}Mapper.toEntityList(dto.get${property.name?cap_first}()));
			</#if>
		</#list>
		return retVal;
	}
	
	public static ArrayList<${class.name}> toEntityList(List<${class.name}DTO> dtos) {
	
	 	ArrayList<${class.name}> retVal = new ArrayList<${class.name}>();
		for(${class.name}DTO dto: dtos){
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
	
	public static ArrayList<${class.name}DTO> toDtoList(List<${class.name}> entities){
	
		ArrayList<${class.name}DTO> retVal = new ArrayList<${class.name}DTO>();
			for(${class.name} entity: entities){
				retVal.add(toDto(entity));
		}
		return retVal;
		
	}
	
}