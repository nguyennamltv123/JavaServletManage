<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.phongban" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Phong Ban</title>
</head>
<body>
	<h1>Admin</h1>
	<table border="1" width="50%">
	<TR><TH>IDPB</TH><TH>Ten Phong Ban</TH><TH>Mo Ta</TH><TH>Xem Nhan Vien</TH></TR>
	<%
	ArrayList<phongban> PBArray = (ArrayList<phongban>)request.getAttribute("PBArray");
	for (int i = 0; i < PBArray.size(); i++) {
	%>
	<tr>
			<td><%= PBArray.get(i).getIDPB() %></td>
			<td><%= PBArray.get(i).getTenPB() %></td>
			<td><%= PBArray.get(i).getMoTa() %></td>
			<td><a href="ChiTietPBServlet?idpb=<%=PBArray.get(i).getIDPB()%>">XXX</a></td>
	</tr>
		<% } %>		
	</table>
	<p><a href='ListNVServlet'>Danh sach nhan vien</a></p>
	<p><a href='AddNVForm.jsp'>Them nhan vien</a></p>
	<p><a href='NhanVienServlet?action=xoa'>Xoa nhan vien</a></p>
	<p><a href='NhanVienServlet?action=xoatatca'>Xoa tat ca nhan vien</a></p>
	<p><a href='SearchNVForm.jsp'>Tim kiem nhan vien</a></p>
	<p><a href='PhongBanServlet?action=sua'>Cap nhat thong tin phong ban</a></p>
	<p><a href='javascript:history.back()'>Back</a></p>
</body>
</html>