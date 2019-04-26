<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update product form</h2>
<div class="content">
  <form enctype="multipart/form-data" method="POST" action="/product/merchant/merchantUpdate.htm">
  				
  				<div class="form-group">
					<label for=categoryName class="col-sm-4 control-label">Category
						Name: </label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="name"
							 value="${sessionScope.product.category.categoryName}" disabled />
					</div>
				</div>
  				
  				<div class="form-group">
					<label for=prodName class="col-sm-4 control-label">Product
						Name: </label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="name"
							 value="${sessionScope.product.prodName}" disabled />
					</div>
				</div>

				<div class="form-group">
					<label for="last" class="col-sm-4 control-label">Product Price:</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" name="price"
							value="${sessionScope.product.prodPrice}" required="required" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="Product Description" class="col-sm-4 control-label">Product Description:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="desc"
							value="${sessionScope.product.prodDecript}" required="required" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="Product Quantity" class="col-sm-4 control-label">Product Quantity:</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" name="quantity"
							value="${sessionScope.product.prodQty}" required="required" />
					</div>
				</div>
				
				<div class="col-sm-offset-4 col-sm-8">
				<input type="submit" class="btn btn-success" value="Update Product" />
				</div>
  </form>
</div>
 <form action="/product/merchant/merchantCont.htm" method="get">
	<input type="submit" value="back" />
</form>
</body>
</html>