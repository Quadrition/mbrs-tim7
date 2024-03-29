<h2>View ${class.name}</h2>

<div ng-init="getOne()">

<form class="form-horizontal">
	<#list properties as property>
		<#if property.upper == 1>
			<#if property.association == false> 
	<div class="form-group">
	    <label class="col-sm-2 control-label">${property.name?cap_first}</label>
	    <div class="col-sm-4">
			<input type="text" class="form-control" ng-model="${class.name?uncap_first}.${property.name}" disabled>
			</#if>
		</div>	
	</div>
		</#if>
 	</#list>
</form>

	<#list properties as property>
		<#if property.upper == -1  &&
		 	property.uiProperty?? && property.uiProperty.label?? > 
<div class="row">
	<h3>${property.uiProperty.label}</h3>
	<div class="col-md-4">
		<ul ng-repeat="${property.type?uncap_first} in ${property.type?uncap_first}List" class="list-group">
			<li class="list-group-item">{{${property.type?uncap_first}}}</li>
		</ul>
	</div>
</div>

		</#if>
	</#list>

</div>

<div class = "row">	
	<uib-alert ng-repeat="alert in alerts" type="{{alert.type}}" close="closeAlert($index)">{{alert.msg}}</uib-alert>	
</div>	