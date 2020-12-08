<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>PWDemo</h1>
	
	<h2>${ message }</h2>
	<h1>Login</h1>
	<form method="post" action="/login">
		Email: <input type="text" name="email" /><br />
		Password: <input type="password" name="password" /><br >
		<input type="submit" />
	</form>
	
	<h1>Register</h1>
	<form method="post" action="/register">
		First Name: <input type="text" name="firstname" /><br />
		Last Name: <input type="text" name="lastname" /><br />
		Email: <input type="text" name="email" /><br />
		Password: <input type="password" name="password" /><br >
		<input type="submit" />
	</form>
</body>
</html>