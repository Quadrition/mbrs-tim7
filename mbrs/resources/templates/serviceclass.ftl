package ${class.typePackage};

import java.util.List;
import java.util.Date;

public interface ${class.name}Service {

	${class.name} findOne(Long id);
	
	List<${class.name}> findAll();
	
	<#list properties as property>
		<#if property.name != "id" && property.upper == 1 && !property.association>
	List<${class.name}> findBy${property.name?cap_first}(${property.type.name} ${property.name});
		</#if>
	</#list>

	<#if class.uiClass?? && ( class.uiClass.create == true || class.uiClass.update)>
	${class.name} save(${class.name}DTO ${class.name?uncap_first});
	</#if>
	<#if class.uiClass?? && (class.uiClass.update == true)>
	${class.name} update(${class.name}DTO ${class.name?uncap_first});
	</#if>
	<#if class.uiClass?? && ( class.uiClass.delete == true)>
	${class.name} remove(Long id);
	</#if>
}