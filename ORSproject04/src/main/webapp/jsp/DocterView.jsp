<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.ORSView"%>
<%@page import="in.co.rays.ctl.DocterCtl"%>
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
	<form action="<%=ORSView.DOCTER_CTL%>" method="post">


		<jsp:useBean id="bean" class="in.co.rays.bean.DocterBean"
			scope="request" />
		<%
			if (bean != null && bean.getId() > 0) {
		%>

		<h1 align="center">Update docter</h1>

		<%
			} else {
		%>
		<h1 align="center">Add docter</h1>

		<%
			}
		%>





		<div align="center">
			<table>
				<h3>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>


				<tr>
					<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
				</tr>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" placeholder="enter name"
						value="<%=DataUtility.getStringData(bean.getName())%>"></td>
				</tr>


				<tr>
					<th>Dob</th>
					<td><input type="text" name="dob" id="udate"
						placeholder="enter date"
						value="<%=DataUtility.getStringData(bean.getDob())%>"></td>
				</tr>

				<tr>
					<th>Mobile</th>
					<td><input type="type" name="mobile"
						placeholder="enter mobile no "
						value="<%=DataUtility.getStringData(bean.getmobile())%>"></td>
				</tr>


				<tr>
					<th>Experties</th>
					<td>
						<%
							HashMap<String, String> expertiesMap = new HashMap<>();
							expertiesMap.put("heatexper", "heartexper");
							expertiesMap.put("tumerexpert", "tumerexpert");
							expertiesMap.put("cancerexpert", "cancerexpert");
						%> <%=HTMLUtility.getList("experties", bean.getexperties(), expertiesMap)%>
					<td>
						

				</tr>


				<tr>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<td><input type="submit" name="operation"
						value="<%=DocterCtl.OP_UPDATE%>"> <input type="submit"
						name="operation" value="<%=DocterCtl.OP_CANCEL%>"></td>


					<%
						} else {
					%>

					<td><input type="submit" name="operation"
						value="<%=DocterCtl.OP_SAVE%>"> <input type="submit"
						name="operation" value="<%=DocterCtl.OP_RESET%>"></td>

					<%
						}
					%>

				</tr>
			</table>

		</div>

	</form>

</body>
</html>