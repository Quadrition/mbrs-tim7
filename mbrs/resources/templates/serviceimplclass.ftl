package ${class.typePackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class ${class.name}ServiceImpl implements ${class.name}Service{

	@Autowired
	private ${class.name}Repository ${class.name?uncap_first}Repository;
	
	<#list properties as property>
		<#if property.association>
	@Autowired
	private ${property.type?cap_first}Repository ${property.type?uncap_first}Reposiroty;
	
		</#if>
	</#list>
	@Override
	public ${class.name} findOne(Long id){
		return ${class.name?uncap_first}Repository.findById(id);
	}
	
	@Override
	List<${class.name}> findAll(){
		return ${class.name?uncap_first}Repository.findAll();
	}
	
	<#list properties as property>
		<#if property.name != "id" && property.upper == 1 && !property.association>
	@Override
	List<${class.name}> findBy${property.name?cap_first}(${property.type} ${property.name}){
		return ${class.name?uncap_first}Repository.findBy${property.name?cap_first}(${property.name});
	}
		</#if>
	</#list>

	@Override
	${class.name} save(${class.name}DTO ${class.name?uncap_first}){
		${class.name} newEntity = new ${class.name}();
		<#list properties as property>
			<#if !property.association>
		newEntity.set${property.name?cap_first}(${class.name?uncap_first}.get${property.name?cap_first}());
			<#else>
				<#if property.upper == 1>
		newEntity.set${property.name?cap_first}(${property.type?uncap_first}Reposiroty.findOne(${class.name?uncap_first}.get${property.name?cap_first}().getId()));	
				<#else>
		// asocijacija ${property.type?uncap_first}Reposiroty		
				</#if>
			</#if>
		</#list>
		
		return ${class.name?uncap_first}Repository.save(newEntity);
	}
	@Override
	${class.name} update(${class.name}DTO ${class.name?uncap_first}){
		${class.name} existing = ${class.name?uncap_first}Repository.findById(id);
		if(existing == null){
			throw new Exception("${class.name} doesn't exist");
		}
		//update entity
		<#list properties as property>
			<#if !property.association>
		existing.set${property.name?cap_first}(${class.name?uncap_first}.get${property.name?cap_first}());
			<#else>
				<#if property.upper == 1>
		existing.set${property.name?cap_first}(${property.type?uncap_first}Reposiroty.findOne(${class.name?uncap_first}.get${property.name?cap_first}().getId()));	
				<#else>
		// asocijacija ${property.type?uncap_first}Reposiroty				
				</#if>
			</#if>
		</#list>
		
		return ${class.name?uncap_first}Repository.save(existing);
	}
	@Override
	${class.name} remove(Long id){
		${class.name} existing = ${class.name?uncap_first}Repository.findById(id);
		if(existing == null){
			throw new Exception("${class.name} doesn't exist");
		}
		${class.name?uncap_first}Repository.delete(existing);
		
		return existing;
	}
}