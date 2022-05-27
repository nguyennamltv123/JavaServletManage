<%@page import="model.bo.PhongBanBO"%>
<%@page import="model.bean.phongban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them Nhan Vien</title>
</head>
<body>
	<table>
	<form action="NhanVienServlet?action=timkiem" method="post">
		<tr>
			<td>IDNV:</td><td><input type="radio" name="luachon" checked="checked" value="idnv"/></td>	
		</tr>
		<tr>
			<td>Ho va ten:</td><td><input type="radio" name="luachon" value="hoten"/></td>	
		</tr>
		<tr>
			<td>Dia chi:</td><td><input type="radio" name="luachon" value="diachi"/></td>
		</tr>
		<tr>
			<td>Nhap vao thong tin:</td><td><input type="text" name="thongtin" /></td>
		</tr>
		<tr><input type="submit" value="OK" /> </tr>
		<tr><input type="reset" value="Reset" /> </tr>
	</form>
	</table>
	<p><a href='javascript:history.back()'>Back</a></p>
</body>
</html>