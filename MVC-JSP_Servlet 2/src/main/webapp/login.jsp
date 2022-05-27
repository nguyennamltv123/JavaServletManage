<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="ListPBServlet?login=admin" method="post">
		Username: <input type="text" name="username" />
		Password: <input type="password" name="password" />
		<input type="submit" value="Login" />
		<input type="reset" value="Reset" />
	</form>
	<p><a href="ListPBServlet?login=guest">Dang nhap voi tu cach khach!!</a></p>
</body>
</html>