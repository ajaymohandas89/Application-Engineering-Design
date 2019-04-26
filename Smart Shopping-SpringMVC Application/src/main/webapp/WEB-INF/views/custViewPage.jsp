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
	<h2>Hello ${sessionScope.customerUserName}</h2>
	
	<h3>List of categories</h3>
	<c:forEach var = "cart" items= "${sessionScope.catList}">
        <ul>
        <li>[<a href="/product/customer/getProduct?selectedCategory=${cart.categoryName}">${cart.categoryName}</a>]&nbsp;&nbsp;</li>
        </ul>
    </c:forEach>

<br/><br/>
<form action="/product/logout.htm"class="form-horizontal" method = "post">
		 	<div class="form-group">
					 <input type="submit" value="Logout">
 			</div>
 		</form>
    
</body>
</html>