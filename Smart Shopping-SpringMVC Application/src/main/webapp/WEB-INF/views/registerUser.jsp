<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>

function isPasswordMatch() {
    var password = $("#txtNewPassword").val();
    var confirmPassword = $("#txtConfirmPassword").val();

    if (password != confirmPassword) $("#divCheckPassword").html("Passwords do not match!");
    else $("#divCheckPassword").html("Passwords match.");
}

$(document).ready(function () {
    $("#txtConfirmPassword").keyup(isPasswordMatch);
});
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<!--javascript -->
	<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
	<!-- to make responsive-->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<style type="text/css">
		body
		{
			background-color: #fff8e6;
			font-size: 16px;
			font-family: Calibri;
		}
		.wrapper{
			text-align :center;
		}
		.btn{
			position:absolute;
			top:102%;
		}
		.myreset{
			position:absolute;
			top:102%;
			left:65%;
		}
	</style>
</head>
<body>
<form class="col-8" action="register" method="post">

	<div class="row form-group">
		<div class="col-3">
		<label for="gender">User Type:</label>
		</div>
		<div class="col-5 form-check-inline">
			 <label class="radio-inline control-label">
				<input type="radio" name="usertype" value="Merchant" class="form-check-input" checked>Merchant
			</label>
			<label class="radio-inline control-label">
			<input type="radio" name="usertype" value="Customer" class="form-check-input">Customer
			</label>
		</div>
	</div>
	<div class="row form-group">
		<div class="col-3">
		<label for="firstName">First name:</label>
		</div>
		<div class="col-5">
		<input type="text" name="firstName" placeholder="firstName" class="form-control" required>
		</div>
	</div>
		<div class="row form-group">
		<div class="col-3">
		<label for="lastName">Last name:</label>
		</div>
		<div class="col-5">
		<input type="text" name="lastName" placeholder="lastName" class="form-control" required>
		</div>
	</div>
		<div class="row form-group">
		<div class="col-3">
		<label for="email">Email id:</label>
		</div>
		<div class="col-5">
		<input type="email" name="emailId" placeholder="emailid" class="form-control" required>
		</div>
	</div>
	
	<div>
	<p>User type will be appended first with the user id</p>
		<div class="row form-group">
		<div class="col-3">
		<label for="username">User id:</label>
		</div>
		<div class="col-5">
		<input type="text" name="username" placeholder="username" class="form-control" required>
		<span id="isE"></span>
		</div>
	</div>
	
	<div class="row form-group">
		<div class="col-3">
		<label for="password">Password:</label>
		</div>
		<div class="col-5">
		<input type="password" name="password"  placeholder="password" class="form-control" id="txtNewPassword" >
		</div>
	</div>

	<div class="row form-group">
		<div class="col-3">
		<label for="confirmpassword">Confirm Password:</label>
		</div>
		<div class="col-5">
		<input type="password" name="confirmpassword"
		placeholder="confirm password" class="form-control"  id="txtConfirmPassword" onChange="isPasswordMatch()">
		</div>
	</div>
	<div id="divCheckPassword"></div>
	<div class="row form-group">
		<div class="col-3">
		<label for="street">Street:</label>
		</div>
		<div class="col-5">
		<input type="text" name="street"
		placeholder="street" class="form-control">
		</div>
	</div>
	
	<div class="row form-group">
		<div class="col-3">
		<label for="city">City:</label>
		</div>
		<div class="col-5">
		<input type="text" name="city"
		placeholder="city" class="form-control">
		</div>
	</div>
	
	<div class="row form-group">
		<div class="col-3">
		<label for="state">State:</label>
		</div>
		<div class="col-5">
		<input type="text" name="state"
		placeholder="state" class="form-control">
		</div>
	</div>
	
	<div class="row form-group">
		<div class="col-3">
		<label for="zip">ZipCode:</label>
		</div>
		<div class="col-5">
		<input type="text" name="zip"
		placeholder="zip" class="form-control">
		</div>
	</div>
	
	<div class="row form-group">
		<div class="col-3">
		<label for="country">Select Country:</label>
		</div>
		<div class="col-5">
		<select name="Country" class="form-control">
		<option value="" selected disabled>Please select</option>	
		<option  value="USA"> USA </option>
		<option  value="INDIA"> INDIA </option>
		<option  value="CHINA"> CHINA </option>
		</select>
		</div>
		
	</div>	
		<div class="row form-group">
		<div class="col-3">
		<label for="primePhone">Primary Contact:</label>
		</div>
		<div class="col-5">
		<input type="text" name="primePhone"
		placeholder="primePhone" class="form-control">
		</div>
	</div>
	
		</div>	
		<div class="row form-group">
		<div class="col-3">
		<label for="secondPhone">Secondary Contact:</label>
		</div>
		<div class="col-5">
		<input type="text" name="secondPhone"
		placeholder="secondPhone" class="form-control">
		</div>
	</div>
	
	<div class= "wrapper">
	<input type="submit" class="btn btn-primary" value="Submit">
	<button type="reset" class="myreset btn btn-secondary">Reset</button></div>
</form>
</body>
</html>