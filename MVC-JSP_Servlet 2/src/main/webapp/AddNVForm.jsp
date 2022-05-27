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
	<form action="NhanVienServlet?action=them" method="post">
		<tr>
			<td>Ma nhan vien:</td><td><input type="text" name="idnv" /></td>	
		</tr>
		<tr>
			<td>Ho va ten:</td><td><input type="text" name="hoten" /></td>	
		</tr>
		<tr>
			<td>Dia chi:</td><td><input type="text" name="diachi" /></td>
		</tr>
		<tr>
			<td>Phong ban:</td><td><select name="idpb">
			<%
			PhongBanBO pbBO = new PhongBanBO();
			ArrayList<phongban> PBArray = new ArrayList<phongban>();
			PBArray = pbBO.getListPhongBan();
			for (int i = 0; i < PBArray.size(); i++) {
			%>
				<option value="<%=PBArray.get(i).getIDPB()%>"><%= PBArray.get(i).getTenPB() %></option>
			<% } %>
	</select></td>
		</tr>
		<input type="submit" value="OK" />
		<input type="reset" value="Reset" />
	</form>
	</table>
	<p><a href='javascript:history.back()'>Back</a></p>
</body>
</html>