<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>COVID-19 Deaths Tracker</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <style>
    	.container{
    		text-align:center;
    	}
    	.container1{
    		text-align:center;
    		background-color: antiquewhite;
    	}
    	.display{
    		line-height:1.2;
    	}
    	.line{
    		margin-top:1.5rem!important;
    	}
    	.table>thead>tr>th {
    		text-align:center;
    	}
    </style>
</head>
<body>

<div class="container">
<h1>COVID-19 Deaths Tracker</h1>

<div class="container1">
    <h1 class="display"><c:out value="${totalReportedDeaths}"/></h1>
    <p class="lead">Total deaths reported as of today</p>
    <hr class="line">
    <p>
        <span>New deaths reported since previous day:</span>
        <span><c:out value="${totalNewDeaths}" /></span>
    </p>

</div>
    <table class="table table-dark">
    	<thead>
        	<tr>
            	<th>Province/State</th>
            	<th>Country</th>
            	<th>Total Deaths Reported</th>
            	<th>Deaths reported in the previous day</th>
            	<th>Changes in reported Deaths since last day</th>
        	</tr>
        </thead>
        <tbody>
        	<c:forEach var="deathsStat"  items="${deathsStats}">
        		<tr>
        			<c:if test="${deathsStat.provinceState == ''}">
            			<td><c:out value="${deathsStat.countryRegion}"/></td>
            		</c:if>
            		<c:if test="${deathsStat.provinceState != ''}">
            			<td><c:out value="${deathsStat.provinceState}"/></td>
            		</c:if>
            		<td><c:out value="${deathsStat.countryRegion}"/></td>
            		<td><c:out value="${deathsStat.latestTotalDeaths}"/></td>
            		<td><c:out value="${deathsStat.prevDayDeaths}"/></td>
            		<td><c:out value="${deathsStat.diffFromPrevDay}"/></td>
        		</tr>
        	</c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>