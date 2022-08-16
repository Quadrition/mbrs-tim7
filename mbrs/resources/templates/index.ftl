<!DOCTYPE html>
<html ng-app="demoApp">
<head>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="/angular-route.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-animate.js"></script>
<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.3.js"></script>

<script src="/static/js/main.js"></script> 
<script src="/static/js/main.controllers.js"></script>
<script src="/static/js/main.services.js"></script>
<script src="/static/js/main.routes.js"></script>

<script src="//unpkg.com/angular-ui-router/release/angular-ui-router.min.js"></script>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link rel="shortcut icon" href="#">
<title>DemoApp</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/#/">Home</a> 
	<#list classes as class>
		<#if class.uiClass??>
				<a class="navbar-brand" href="/#/${class.name?uncap_first}List">${class.name?uncap_first}</a>
		</#if>
	</#list>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>Demo App</h1>
			<p>Generated Web Application</p>
		</div>
	</div>
	
	<div class="container" ng-view>	
	</div>	
	<hr>
	
</body>
</html>