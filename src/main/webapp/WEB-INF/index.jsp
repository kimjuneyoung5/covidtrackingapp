<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>COVID-19 Tracker</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <style>
    	.container1{
    		text-align: center;
    	}
    	.container{
    		text-align:center;
    		background-color: antiquewhite;
    	}
    	.line{
    		margin-top:1.5rem!important;
    	}
    	.display{
    		line-height:1.2;
    	}
    	hr{
    		border-top:1px solid black;
    	}
    </style>
</head>

<body>
<div class="container1">
<h1>COVID-19 Tracker</h1>

	<div class="container">
    	<p class="lead">Total cases reported as of today:</p>
    	<h1 class="display"><c:out value="${totalReportedCases}"/></h1>
    	<hr class="line">
    	<p class="lead">Total deaths reported as of today:</p>
    	<h1 class="display"><c:out value="${totalReportedDeaths}"/></h1>
    	<hr class="line">
    	<a href="/cases">Reported Cases per States</a>
    	<br></br>
    	<a href="/deaths">Reported Deaths per States</a>
    	<br></br>
    	<a href="/graph">Simple graph</a>
	</div>
</div>

</body>
</html>











