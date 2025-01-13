<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.ctl.CustomerListCtl"%>
<%@page import="in.co.rays.bean.CustomerBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="java.util.List"%>
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

	<form action="<%=ORSView.CUSTOMER_LISTCTL%>" method="post">


		<jsp:useBean id="bean" class="in.co.rays.bean.CustomerBean"
			scope="request"></jsp:useBean>

		<div align="center">
			<h1>Customer List</h1>


			<tr>


				<th align="left">Importance<span style="color: red">*</span></th>
				<td>
					<%
						HashMap<String, String> importanceMap = new HashMap<>();
						importanceMap.put("high", "high");
						importanceMap.put("low", "low");
						importanceMap.put("medium", "medium");
					%> <%=HTMLUtility.getList("Importance", bean.getImportance(), importanceMap)%>
				</td>

				<td><input type="submit" name="operation"
					value="<%=CustomerListCtl.OP_SEARCH%>"></td>

			</tr>


			<%
				List list = ServletUtility.getList(request);

				int index = 1;
			%>
			<table border="1px" style="width: 100%">



				<th><input type="checkbox" id="selectall"></th>
				<th>sNO</th>
				<th>Client Name</th>
				<th>Location</th>
				<th>Number</th>
				<th>Importance</th>


				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						bean = (CustomerBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getClientName()%></td>
					<td><%=bean.getLocation()%></td>
					<td><%=bean.getNumber()%></td>
					<td><%=bean.getImportance()%></td>
				</tr>

				<%
					}
				%>



			</table>
			<table>
				<tr>
					<td><input type="submit" name="operation"
						value="<%=CustomerListCtl.OP_DELETE%>"></td>

				</tr>



			</table>
		</div>




	</form>
</body>
</html>