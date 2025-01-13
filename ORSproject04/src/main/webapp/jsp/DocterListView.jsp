
<%@page import="in.co.rays.ctl.DocterListCtl"%>
<%@page import="in.co.rays.bean.DocterBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@ include file="Header.jsp"%>
	<form action="<%=ORSView.DOCTER_LIST_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.DocterBean"
			scope="request"></jsp:useBean>

		<div align="center">
			<%
				List list = ServletUtility.getList(request);
			%>

			<h1>Docert List</h1>

			<table border="1%" style="width: 100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>Name</th>
					<th>Date</th>
					<th>Mobile</th>
					<th>Experties</th>
					<th>Edit</th>
				</tr>

				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						bean = (DocterBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getmobile()%></td>
					<td><%=bean.getexperties()%></td>
					<td><a href="<%=ORSView.DOCTER_CTL%>?id=<%=bean.getId()%>">Edit</a></td>

				</tr>

				<%
					}
				%>
			</table>
			<table>
				<tr>
					<td><input type="submit" name="operation"
						value="<%=DocterListCtl.OP_DELETE%>"></td>
				</tr>

			</table>
		</div>
	</form>

</body>
</html>