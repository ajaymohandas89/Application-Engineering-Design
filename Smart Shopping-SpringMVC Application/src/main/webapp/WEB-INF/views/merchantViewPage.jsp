<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
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
<h2>Welcome Back ${sessionScope.merchantName}</h2>
<br/><br/>
<form action="/product/logout.htm"class="form-horizontal" method = "post">
		 	<div class="form-group">
					 <input type="submit" value="Logout">
 			</div>
 		</form>
<p>Please select any of the following option:</p>

<button class="collapsible">Add New Products</button>
<div class="content">
  <form:form commandName="product" enctype="multipart/form-data" class="form-horizontal">  				
  				
  				<div class="form-group">
				<label for="categoryName" class="col-sm-4 control-label">Category Name:</label>
					<div class="col-sm-8">
			 		<select name="categoryName">
			  			<c:forEach items="${sessionScope.categoryList}" var="category">
							<option value="${category.categoryName}">${category.categoryName}</option>
			  			</c:forEach>
			  		</select>
			  		</div>
			  	</div>
  				
  				<div class="form-group">
					<label for=prodName class="col-sm-4 control-label">Product
						Name: </label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="prodName"
							path="prodName" placeholder="Product Name" required="required" />
					</div>
				</div>

				<div class="form-group">
					<label for="last" class="col-sm-4 control-label">Product Price:</label>
					<div class="col-sm-8">
						<form:input type="number" class="form-control" id="prodPrice" path="prodPrice"
							placeholder="Product Price" required="required" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="Product Description" class="col-sm-4 control-label">Product Description:</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="prodDescript" path="prodDecript"
							placeholder="Product Description" required="required" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="Product Quantity" class="col-sm-4 control-label">Product Quantity:</label>
					<div class="col-sm-8">
						<form:input type="number" class="form-control" id="prodQty" path="prodQty"
							placeholder="Product Quantity" required="required" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="photo" class="col-sm-4 control-label">Photo: </label>
					<div class="col-sm-4">
						<input type="file" id="photo" name="photo" required="required" />
						<p class="help-block">Recent photo in JPG format</p>
					</div>
				</div>
				
				<div class="col-sm-offset-4 col-sm-8">
				<input type="submit" class="btn btn-success" value="Add Product" />
				</div>
  </form:form>
</div>
<button class="collapsible">Update a Product</button>
<div class="content">
  <form action="/product/merchant/merchantUpdate.htm" enctype="multipart/form-data" class="form-horizontal">
  <div class="form-group">
					<label for="Product Name" class="col-sm-4 control-label">Please Enter a Product Name:</label>
					<div class="col-sm-8">
					<input type="text" name="productName" value="" required/>
					</div>
					 <input type="submit" value="Submit">
 </div>
  <br/>
  </form>
</div>
<button class="collapsible">User Product Reviews</button>
<div class="content">
<c:forEach var="prod" items="${sessionScope.Product}" varStatus="feedback">
	Product Name: <c:out value="${prod}"/><br/>
	Product FeedBack: <c:out value="${sessionScope.Feedbacks[feedback.index]}"/><br/><br/>
</c:forEach>
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