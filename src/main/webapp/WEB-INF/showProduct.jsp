<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1><c:out value="${product.name}"/></h1>
		<div style="display:flex">
			<div>
				<h3>Categories:</h3>
				<div>
					<ul>
					<c:forEach var="category" items="${product.categories}">
							<li><c:out value="${category.name}"/></li>
					</c:forEach>
					</ul>
				</div>
			</div>
			<div>
				<form action="/products/add" method="post">
					<input type="hidden" value="${product.id}" name="product">
					<select name="category">
						<c:forEach var="category" items="${categories}">
							<option value="${category.id}"><c:out value="${category.name}"/></option>
						</c:forEach>
					</select>
					<input type="submit" value="Add">
				</form>
			</div>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>