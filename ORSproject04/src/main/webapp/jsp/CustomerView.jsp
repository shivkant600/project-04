<%@page import="in.co.rays.ctl.CustomerCtl"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
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
	<form action="<%=ORSView.CUSTOMER_CTL%>" method="post">
		<jsp:useBean id="bean" class="in.co.rays.bean.CustomerBean"
			scope="request" />


		<div align="center">

			<table>
				<h1>ADD Customer</h1>


				<!-- Success and Error Messages -->
				<h3>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>


				<tr>

					<input type="hidden" name="id" value="<%=bean.getId()%>">




				</tr>

				<tr>
					<th align="left">ClientName<span style="color: red">*</span></th>
					<td><input type="text" name="ClientName"
						placeholder="Enter client Name"
						value="<%=DataUtility.getStringData(bean.getClientName())%>" /></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("ClientName", request)%></font></td>

				</tr>
				<tr>
					<th align="left">Location<span style="color: red">*</span></th>
					<td><input type="text" name="Location"
						placeholder="Enter Location"
						value="<%=DataUtility.getStringData(bean.getLocation())%>" /></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Location", request)%></font></td>

				</tr>
				<tr>
					<th align="left">Number<span style="color: red">*</span></th>
					<td><input type="text" name="Number"
						placeholder="Enter Number"
						value="<%=DataUtility.getStringData(bean.getNumber())%>" /></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Number", request)%></font></td>

				</tr>
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
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Importance", request)%></font></td>


				</tr>
			</table>


			<table>

				<input type="submit" name="operation"
					value="<%=CustomerCtl.OP_SAVE%>">



			</table>
		</div>












	</form>
</body>
</html>