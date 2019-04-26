<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.myproject.product.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>List of products</h3>
<a href="/product/customer/getPDFView?selectedCategory=${sessionScope.categoryName}">View PDF</a><br><br>
	<c:forEach var = "prod" items="${sessionScope.allProdList}">
		<ul>
        <li>[<a href="/product/customer/prodData?selectedProduct=${prod.prodName}">${prod.prodName}</a>]</li>
        </ul>
	</c:forEach>
	
<form action="/product/customer/categoryList.htm" method="get">
	<input type="submit" value="back" />
</form>
</body>
</html>