<#if class.uiClass??>
	
<a class="btn btn-primary btn-sm"  href="/#/${class.name?uncap_first}List/add">  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
</svg> Add</a>
<br>	
<div ng-init="page=1; getAll();">

	
<table class="table table-hover">
	<thead>
		<tr>
			<#list properties as property>
				<#if property.upper == 1 && (!property.hidden?? || property.hidden == false)>  	
					<#if property.association == false || (property.zoom?? && property.zoom == true && property.zoomPresPropertyName??)>
			<td>${property.name?cap_first}</td>
					</#if>
				</#if>
			</#list>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="${class.name?uncap_first} in ${class.name?uncap_first}List">
			<#list properties as property>
				<#if property.upper == 1 && (!property.hidden?? || property.hidden == false)>
					<#if property.association == false> 
			<td>{{ ${class.name?uncap_first}.${property.name} }}</td>			
					<#elseif property.zoom?? && property.zoom == true && property.zoomPresPropertyName??>
			<td>{{ ${class.name?uncap_first}.${property.name}.${property.zoomPresPropertyName} }}</td>	
					</#if>
			
				</#if>
			</#list>
			<td>
				<a class="btn btn-warning btn-sm" href="/#/${class.name?uncap_first}List/edit/{{ ${class.name?uncap_first}.id }}">edit</a>
				<a class="btn btn-success btn-sm" href="/#/${class.name?uncap_first}List/{{ ${class.name?uncap_first}.id }}">view</a>
				<button class="btn btn-danger btn-sm" ng-click="remove(${class.name?uncap_first}.id)">delete</button>
			</td>
		</tr>
	</tbody>
</table>
</#if>
