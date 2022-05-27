<%@page import="model.bo.PhongBanBO"%>
<%@page import="model.bean.phongban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sua Thong Tin Phong Ban</title>
</head>
<body>
	<table>
	<form action="PhongBanServlet?action=xacnhansua" method="post">
		<%
			phongban pb = (phongban)request.getAttribute("phongban");
		%>
		<tr>
			<td>Ma phong ban:</td><td><input type="text" name="idpb" value ="<%=pb.getIDPB() %>" readonly="readonly"/></td>	
		</tr>
		<tr>
			<td>Ten phong ban:</td><td><input type="text" name="tenpb" value="<%=pb.getTenPB() %>" /></td>	
		</tr>
		<tr>
			<td>Mo ta:</td><td><input type="text" name="mota" value="<%=pb.getMoTa() %>"/></td>
		</tr>
		<input type="submit" value="OK" />
		<input type="reset" value="Reset" />
	</form>
	</table>
	<p><a href='javascript:history.back()'>Back</a></p>
</body>
</html>