<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.myproject.product.pojo.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="customer" value="${requestScope.userList}"/>
            <c:out value="${customer.getFirstName() }"/>
            <c:out value="${customer.getLastName()}"/><br/>
            <c:out value="${customer.getCustUserName()}"/><br/>
            <c:out value="${customer.getVisitCount()}"/><br/>
                 
    <c:set var="merchant" value="${requestScope.userList}"/>
            <c:out value="${merchant.getFirstName() }"/>
            <c:out value="${merchant.getLastName()}"/><br/>
            <c:out value="${customer.getMerchantUserName()}"/><br/>
            <c:out value="${customer.getVisitCount()}"/><br/>
</body>
</html>