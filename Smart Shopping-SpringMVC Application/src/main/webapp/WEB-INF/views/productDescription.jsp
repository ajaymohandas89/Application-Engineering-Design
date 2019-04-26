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
<h1>List of Products</h1>
	<c:set var="product" value= "${sessionScope.prodList}"/>
	<b>Name:<c:out value="${product.getProdName()}"/></b><br/><br/>
	
           
            Price:<c:out value="${product.getProdPrice()}"/><br/>
            Description:<c:out value="${product.getProdDecript()}"/><br/> 
 			View Count:<c:out value="${product.getUserViewCount()}"/><br/><br/>
 			
 			<img src="<c:url value="C:/Users/Welcome/Desktop/FinalProject_ProductFiles/${product.getProdImage()}"/>" alt="image"
                             width="200px" height="600px"/><br/><br/>
 	<br/><br/><h2>Customer Reviews</h2>
 	<ul>
 		<c:forEach var="feed" items="${sessionScope.feedList}">
 			<li><c:out value="${feed.getFeedBack()}"/></li>
 		</c:forEach>
 	</ul>
 	<br/>
 	<br/>
 	
 	<h3>Add your feedback</h3>
 	<form action="/product/customer/addFeedback" method="post">
 		Enter your feedback:<input type="text" name="feedback"/>
 		<input type="submit" value="Add"/>
 	</form>
 
 <form action="/product/customer/categoryList.htm" method="get">
	<input type="submit" value="back" />
</form>
</body>
</html>