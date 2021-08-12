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
		<h1><c:out value="${category.name}"/></h1>
		<div style="display:flex">
			<div>
				<h3>Products:</h3>
				<div>
					<ul>
					<c:forEach var="product" items="${category.products}">
							<li><c:out value="${product.name}"/></li>
					</c:forEach>
					</ul>
				</div>
			</div>
			<div>
				<form action="/categories/add" method="post">
					<input type="hidden" value="${category.id}" name="category">
					<select name="product">
						<c:forEach var="product" items="${products}">
							<option value="${product.id}"><c:out value="${product.name}"/></option>
						</c:forEach>
					</select>
					<input type="submit" value="Add">
				</form>
			</div>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>