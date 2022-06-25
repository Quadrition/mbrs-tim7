package ${class.typePackage};

<#assign mylist=class.typePackage?split(".")>

<#assign x=mylist?size-2>
<#assign baseDir=mylist[0]>

<#list 1..x as i>
	<#assign baseDir = baseDir+"."+mylist[i]>
</#list>

import ${baseDir}.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

@Entity
@Table(name="${class.name?uncap_first}_table")
${class.visibility} class ${class.name} { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 

<#list properties as property>
	<#if property.upper == -1 >  
	@OneToMany
	${property.visibility} List<<#if property.type.name == "date" > Date <#else>${property.type.name} </#if>> <#if property.name != "" > ${property.name} <#else> ${property.type.name?uncap_first}</#if> = new ArrayList<${property.type.name}>();

    <#elseif property.upper == 1 > 
	
	<#if property.association==true>
	  	<#if property.aggregationType =="composite" || property.aggregationType =="shared" >
	@OneToOne
	  	<#else>
	@ManyToOne(fetch=FetchType.LAZY)
		</#if>
	  <#else>
	@Column
	  </#if> 
	${property.visibility} <#if property.type.name == "date" > Date <#else>${property.type.name} </#if><#if property.name != "" > ${property.name} <#else> ${property.type.name?uncap_first}</#if>;
   
    <#else>   
    	<#list 1..property.upper as i>
	${property.visibility} ${property.type.name} ${property.name}${i};
		</#list>  
    </#if>     
</#list>

	public ${class.name}(){}
      
	public ${class.name}(Long id,<#list properties as property><#if property.upper == 1><#if property.type.name == "date" > Date <#else>${property.type.name} </#if>  <#if property.name != "" >${property.name} <#else>${property.type.name?uncap_first}</#if><#elseif property.upper == -1 >ArrayList<<#if property.type.name == "date" > Date <#else>${property.type.name} </#if>> <#if property.name != "" > ${property.name} <#else> ${property.type.name?uncap_first}</#if><#else><#list 1..property.upper as i>${property.type.name} ${property.name}${i}<#if i < property.upper>,</#if></#list></#if><#if property_has_next>,</#if></#list>
		){
		this.id = id; 
		<#list properties as property>
		<#if property.upper == 1>
		this.<#if property.name != "" >${property.name} <#else>${property.type.name?uncap_first}</#if> = <#if property.name != "" > ${property.name} <#else> ${property.type.name?uncap_first}</#if>;
		<#elseif property.upper == -1 >
		this.<#if property.name != "" >${property.name} <#else>${property.type.name?uncap_first}</#if>  = <#if property.name != "" > ${property.name} <#else> ${property.type.name?uncap_first}</#if> ;
		<#else>
			<#list 1..property.upper as i>
		this.${property.name}${i} = ${property.name}${i};
			</#list>
		</#if>
		</#list>
		}
      
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
<#list properties as property>
	<#if property.upper == -1 >   
     public List<${property.type.name}> get${property.name?cap_first}(){
          return ${property.name};
     }
      
     public void set${property.name?cap_first}(List<${property.type.name}> ${property.name}){
          this.${property.name} = ${property.name};
     }
      
    <#elseif property.upper == 1 >
     public ${property.type.name} get${property.name?cap_first}(){
          return ${property.name};
     }
      
     public void set${property.name?cap_first}(${property.type.name} ${property.name}){
          this.${property.name} = ${property.name};
     }
      
    <#else>   
    	<#list 1..property.upper as i>
     public ${property.type.name} get${property.name?cap_first}${i}(){
          return ${property.name}${i};
     }
      
     public void set${property.name?cap_first}${i}(${property.type.name} ${property.name}${i}){
          this.${property.name}${i} = ${property.name}${i};
     }
            
		</#list>  
    </#if>     
</#list>

}
