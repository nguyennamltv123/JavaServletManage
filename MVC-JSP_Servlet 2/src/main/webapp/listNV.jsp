<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.nhanvien" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Nhan Vien</title>
</head>
<body>
	<table border="1" width="50%">
	<TR><TH>IDNV</TH><TH>Ho Ten</TH><TH>IDPB</TH><TH>Dia Chi</TH></TR>
	<%
	ArrayList<nhanvien> NVArray = (ArrayList<nhanvien>)request.getAttribute("NVArray");
	for (int i = 0; i < NVArray.size(); i++) {
	%>
	<tr>
			<td><%= NVArray.get(i).getIDNV() %></td>
			<td><%= NVArray.get(i).getHoten() %></td>
			<td><%= NVArray.get(i).getIDPB() %></td>
			<td><%= NVArray.get(i).getDiaChi() %></td>
	</tr>
		<% } %>		
	</table>
	<p><a href='javascript:history.back()'>Back</a></p>
</body>
</html>