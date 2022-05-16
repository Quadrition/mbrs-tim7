package ${class.typePackage};

import java.util.List;
import java.util.Date;

public interface ${class.name}Service {

	${class.name} findOne(Long id);
	
	List<${class.name}> findAll();
	
	<#list properties as property>
		<#if property.name != "id" && property.upper == 1>
	List<${class.name}> findBy${property.name?cap_first}(${property.type} ${property.name});
		</#if>
	</#list>

	${class.name} save(${class.name}DTO ${class.name?uncap_first});
	${class.name} update(${class.name}DTO ${class.name?uncap_first});
	${class.name} remove(Long id);
}