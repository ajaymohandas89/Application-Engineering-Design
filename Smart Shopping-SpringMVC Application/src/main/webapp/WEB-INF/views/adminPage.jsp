<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.collapsible {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
</head>
<body>
<h2>Welcome Admin ${sessionScope.adminName}!</h2>

<form action="/product/logout.htm"class="form-horizontal" method = "post">
		 	<div class="form-group">
					 <input type="submit" value="Logout">
 			</div>
 		</form>
 		<br/><br/>
 		
 <form action="/product/admin/completeInfo.htm" method="get">
	<input type="submit" value="Refresh" />
</form>

<button class="collapsible">Create New Category</button>
<div class="content">
  <form action="/product/admin/createCategory.htm"class="form-horizontal" method = "post">
  <div class="form-group">
					<label for="Category Name" class="col-sm-4 control-label">Please Enter a Category Name:</label>
					<div class="col-sm-8">
					<input type="text" name="categoryName" value=""/> <br/>
					<label for="Category Name" class="col-sm-4 control-label">Please Enter a Category Description:</label>
					<div class="col-sm-8">
					<input type="text" name="categoryDesc" value=""/>
					</div>
					 <input type="submit" value="Submit">
 					</div>
 </div>
  <br/>
  </form>
</div>


<button class="collapsible">Show Categories</button>
<div class="content">
<table>
	<tr>
 		<th>Name: </th><th>Description: </th> 
 	</tr>
 	<c:forEach var="category" items="${sessionScope.categoryList}">
 		<tr>
 			<td>${category.categoryName}</td><td>${category.categoryDescript}</td> 
 		</tr>
	</c:forEach>
</table>
</div>
<button class="collapsible">Show Customers</button>
<div class="content">
<table>
		<tr>
 			<th>First name: </th><th>Last Name: </th><th>Email ID: </th> 
 		</tr>
 		<c:forEach var="customer" items="${sessionScope.curtomerList}">
 			<tr>
 				<td>${customer.firstName}</td><td>${customer.lastName}</td><td>${customer.emailId}</td>  
 			</tr>
		</c:forEach>
</table>
</div>
<button class="collapsible">Show Merchants</button>
<div class="content">
<table>
	<tr>
 		<th>First name: </th><th>Last Name: </th><th>Email ID: </th> 
 	</tr>
 	<c:forEach var="merc" items="${sessionScope.merchantList}">
 		<tr>
 			<td>${merc.firstName}</td><td>${merc.lastName}</td><td>${merc.emailId}</td>  
 		</tr>
	</c:forEach>
</table>
</div>
<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>

</body>
</html>