<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Category</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1>New Category</h1>
		<div>
			<form:form action="/categories/create" method="post" modelAttribute="category">
					<form:label path="name">Name: </form:label>
					<form:input path="name"/>
					<form:button>Create</form:button>
			</form:form>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>