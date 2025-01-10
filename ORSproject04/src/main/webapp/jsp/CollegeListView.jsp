<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.model.CollegeModel"%>
<%@page import="in.co.rays.ctl.CollegeListCtl"%>
<%@page import="in.co.rays.ctl.CollegeCtl"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.bean.CollegeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<div align="center">
		<form action="<%=ORSView.COLLEGE_LIST_CTL%>" method="post">


			<jsp:useBean id="bean" class="in.co.rays.bean.CollegeBean"
				scope="request"></jsp:useBean>

			<%
				List list = ServletUtility.getList(request);

				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);

				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

				Iterator it = list.iterator();
			%>

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">

			<h1>College List</h1>

			<table>


				<th>Name :</th>
				<td><input type="text" name="Name" placeholder="Enter Name"></td>


				<td><input type="submit" name="operation"
					value="<%=CollegeListCtl.OP_SEARCH%>"></td>




			</table>

			<br>

			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Name</th>
					<th>Address</th>
					<th>State</th>
					<th>City</th>
					<th>Phone No.</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
						bean = (CollegeBean) it.next();
				%>

				<tr align="center">
					<td><input type="checkbox" name="ids" class="case"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getState()%></td>
					<td><%=bean.getCity()%></td>
					<td><%=bean.getPhoneNo()%></td>
					<td><a href="<%=ORSView.COLLEGE_CTL%>?id=<%=bean.getId()%>">edit</a></td>
				</tr>

				<%
					}
				%>

			</table>

			<table width=100%>

				<td align="left"><input type="submit" name="operation"
					value="<%=CollegeListCtl.OP_PREVIOUS%>"
					<%=(pageNo == 1) ? "disabled" : ""%>></td>

				<td style="width: 30%"><input type="submit" name="operation"
					value="<%=CollegeListCtl.OP_NEW%>"></td>
				<td style="width: 25%"><input type="submit" name="operation"
					value="<%=CollegeListCtl.OP_DELETE%>"></td>

				<td align="right"><input type="submit" name="operation"
					value="<%=CollegeListCtl.OP_NEXT%>"
					<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
			</table>
		</form>
	</div>
</body>
</html>