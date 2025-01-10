<%@page import="in.co.rays.ctl.PurchaseListCtl"%>
<%@page import="in.co.rays.model.PurchaseModel"%>
<%@page import="in.co.rays.bean.PurchaseBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.ctl.UserListCtl"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.ORSView"%>
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

	<form action="<%=ORSView.PURCHASE_LIST_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.PurchaseBean"
			scope="request" />

		<div align="center">
			<h1>Purchase List</h1>

			<%
				List list = ServletUtility.getList(request);
			%>

			<table border="1%" style="width: 100%">
				<tr style="background-color: lavender; color: black;">
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Purchase Date</th>
					<th>Order Type</th>
					<th>Edit</th>
				</tr>
				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						bean = (PurchaseBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>

					<td><%=bean.getId()%></td>
					<td><%=bean.getQuantity()%></td>
					<td><%=bean.getPrice()%></td>
					<td><%=bean.getPurchasedate()%></td>
					<td><%=bean.getOrdertype()%></td>

					<td><a href="<%=ORSView.PURCHASE_CTL%>?id=<%=bean.getId()%>">edit</a></td>
				</tr>
				<%
					}
				%>
			</table>

			<table>
				<td style="width: 30%"><input type="submit" name="operation"
					value="<%=PurchaseListCtl.OP_NEW%>"></td>
				<td style="width: 25%"><input type="submit" name="operation"
					value="<%=PurchaseListCtl.OP_DELETE%>"></td>
			</table>

		</div>
	</form>
</body>
</html>


