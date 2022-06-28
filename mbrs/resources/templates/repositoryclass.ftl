package ${class.typePackage};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;


<#assign mylist=class.typePackage?split(".")>


<#assign x=mylist?size-2>
<#assign baseDir=mylist[0]>

<#list 1..x as i>
	<#assign baseDir = baseDir+"."+mylist[i]>
</#list>

import ${baseDir}.model.*;

/*
WARNING: This file was auto-generated by MagicDraw MBRS plug-in. 
Don't update it, because if you run the generator again, your changes will be over overrode!
*/

@Repository
public interface ${class.name}Repository extends JpaRepository<${class.name}, Long> {

	<#list properties as property>
		<#if property.upper == 1 && property.association == true>
		List<${class.name}> findBy<#if property.name != "">${property.name?cap_first}<#else>${property.type.name}</#if>(Long id);
		</#if>
	
		<#if property.name != "password" && property.name != "id" &&  property.upper == 1 && property.association == false>
	List<${class.name}> findBy${property.name?cap_first}(<#if property.type.name == "date"> Date <#else>${property.type.name} </#if> ${property.name});
	
		</#if>
		
 	</#list>
}