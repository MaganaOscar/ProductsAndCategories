<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Product</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1>New Product</h1>
		<div>
			<form:form action="/products/create" method="post" modelAttribute="product">
				<form:label path="name">Name: </form:label>
				<form:input path="name"/>
				<form:label path="description">Description: </form:label>
				<form:input path="description"/>
				<form:label path="price">Price: </form:label>
				<form:input path="price" step="0.01" type="number"/>
				
				<form:button>Create</form:button>
			</form:form>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>