<%@page import="javax.management.relation.Role"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.ctl.RoleCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Header.jsp"%>

	<form action="<%=ORSView.ROLE_CTL%>" method="post">
		<jsp:useBean id="bean" class="in.co.rays.bean.RoleBean"
			scope="request" />

		<%
			if (bean != null && bean.getId() > 0) {
		%>
		<h1 align="center">Update Role</h1>
		<%
			} else {
		%>


		<h1 align="center">
			<font color="navy">Add Role</font>
		</h1>

		<%
			}
		%>



		<!-- Hidden Fields -->
		<input type="hidden" name="id" value="<%=bean.getId()%>" /> <input
			type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>" /> <input
			type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>" />
		<input type="hidden" name="createdDatetime"
			value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>" />
		<input type="hidden" name="modifiedDatetime"
			value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>" />



		<table align="center">



			<tr>


				<th align="left">Name<span style="color: red">*</span></th>
				<td><input type="text" name="Name"
					value="<%=DataUtility.getStringData(bean.getName())%>"
					placeholder="Enter Your Name"></td>



				<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Name", request)%></font></td>

			</tr>

			<tr>


				<th align="left">Description<span style="color: red">*</span></th>
				<td><input type="text" name="description"
					value="<%=DataUtility.getStringData(bean.getDescription())%>"
					placeholder="Enter Description"></td>



				<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("description", request)%></font></td>

			</tr>
		</table>

		<table align="center">
			<tr>
				<%
					if (bean != null && bean.getId() > 0) {
				%>
				<td align="left" colspan="2"><input type="submit"
					name="operation" value="<%=RoleCtl.OP_UPDATE%>"> <input
					type="submit" name="operation" value="<%=RoleCtl.OP_CANCEL%>">
					<%
						} else {
					%>
				<td align="left" colspan="2"><input type="submit"
					name="operation" value="<%=RoleCtl.OP_SAVE%>"> <input
					type="submit" name="operation" value="<%=RoleCtl.OP_RESET%>">
					<%
						}
					%>
			</tr>
		</table>




	</form>
</body>
</html>