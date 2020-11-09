<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<tiles:importAttribute name="cssList"/>
<tiles:importAttribute name="jsList"/>
<c:forEach var="cssVal" items="${cssList}">
	<link rel="stylesheet" href="<%=request.getContextPath()%>${cssVal}">
</c:forEach>
<c:forEach var="jsVal" items="${jsList}">
	<script src="<%=request.getContextPath()%>${jsVal}"></script>
</c:forEach>
</head>
<body>
<div class="wrapper">
	<tiles:insertAttribute name="header" />
	<div class="container">
		<div class="row" id="element">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
			<tiles:insertAttribute name="operazioniDx"></tiles:insertAttribute>
		</div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</div>
</body>
</html>