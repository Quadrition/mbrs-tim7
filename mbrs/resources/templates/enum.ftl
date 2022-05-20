package ${enum.typePackage};

public enum ${enum.name}{

	<#if values?size != 0>
	<#list values as e>${e} <#if e_has_next>,</#if>
	</#list>;</#if>
}