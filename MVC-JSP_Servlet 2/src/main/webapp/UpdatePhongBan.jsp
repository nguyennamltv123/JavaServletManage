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
	<table border="1" width="50%">
	<TR><TH>Ma Phong Ban</TH><TH>Ten Phong Ban</TH><TH>Mo Ta</TH><TH>Cap Nhat</TH></TR>
	<%
	ArrayList<phongban> PBArray = (ArrayList<phongban>)request.getAttribute("PBArray");
	for (int i = 0; i < PBArray.size(); i++) {
	%>
	<tr>
			<td><%= PBArray.get(i).getIDPB() %></td>
			<td><%= PBArray.get(i).getTenPB() %></td>
			<td><%= PBArray.get(i).getMoTa() %></td>
			<td><a href="PhongBanServlet?action=chondesua&idpb=<%=PBArray.get(i).getIDPB() %>">XXX</a></td>
	</tr>
		<% } %>		
	</table>
	<p><a href='javascript:history.back()'>Back</a></p>
</body>
</html>