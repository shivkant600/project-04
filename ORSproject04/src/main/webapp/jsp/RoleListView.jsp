<%@page import="in.co.rays.ctl.RoleListCtl"%>
<%@page import="in.co.rays.ctl.RoleCtl"%>
<%@page import="in.co.rays.model.RoleModel"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.bean.RoleBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role List</title>
</head>
<body>

	<%@include file="Header.jsp"%>

	<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">
		<jsp:useBean id="bean" class="in.co.rays.bean.RoleBean"
			scope="request" />

		<%
			// Retrieve role list and pagination information
			List list = ServletUtility.getList(request);
			List roleList = (List) request.getAttribute("roleList");

			int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
			int index = ((pageNo - 1) * pageSize) + 1;
			int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

			Iterator it = list.iterator();
		%>

		<h1 align="center">Role List</h1>

		<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
			type="hidden" name="pageSize" value="<%=pageSize%>">

		<!-- Search Form -->
		<table align="center">
			<tr>
				<th>Role:</th>
				<td><%=HTMLUtility.getList("roleId", DataUtility.getStringData(bean.getId()), roleList)%></td>
				<th>Name:</th>
				<td><input type="text" name="Name" placeholder="Enter Name"></td>
				<td><input type="submit" name="operation" value="Search"></td>
				<td><input type="submit" name="operation" value="Reset"></td>
			</tr>
		</table>

		<br> <br>

		<!-- Role List Table -->
		<table border="1px" width="100%">
			<tr>
				<th><input type="checkbox"></th>
				<th>S.No</th>
				<th>Role ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Edit</th>
			</tr>

			<%
				while (it.hasNext()) {
					bean = (RoleBean) it.next();
					RoleModel model = new RoleModel();
					RoleBean userbean = model.findByPk(bean.getId());
			%>

			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getDescription()%></td>
				<td><a href="<%=ORSView.ROLE_CTL%>?id=<%=bean.getId()%>"
					<%if (userBean.getId() == bean.getId() && bean.getId() == RoleBean.ADMIN) {%>
					onclick="return false;" <%}%>>edit</a></td>
			</tr>

			<%
				}
			%>
		</table>

		<!-- Pagination Controls -->
		<table width="100%">
			<tr>
				<td align="left"><input type="submit" name="operation"
					value="<%=RoleListCtl.OP_PREVIOUS%>"
					<%=(pageNo == 1) ? "disabled" : ""%>></td>

				<td align="center"><input type="submit" name="operation"
					value="<%=RoleListCtl.OP_DELETE%>"></td>

				<td align="center"><input type="submit" name="operation"
					value="<%=RoleListCtl.OP_NEW%>"></td>

				<td align="right"><input type="submit" name="operation"
					value="<%=RoleListCtl.OP_NEXT%>"
					<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
			</tr>
		</table>

	</form>

</body>
</html>