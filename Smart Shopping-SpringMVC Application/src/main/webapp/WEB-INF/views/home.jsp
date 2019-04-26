<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
		input[type=submit] {
    padding:5px 15px; 
    background:#E6E6FA; 
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
}
	</style>
</head>
<body>
<h1>
	Welcome to BestBuyDeals
</h1>

<form action="login" method="post">
		Username:<input type="text" name="username" required/><br/>
		Password:<input type="password" name="password" required/><br/><br/>
		<input type="submit" value="Submit"/>
</form>
<br/><br/>
<form action="/product/newRegisterUser" method="get">
	<input type="submit" value="Click to register" />
</form>

</body>
</html>
