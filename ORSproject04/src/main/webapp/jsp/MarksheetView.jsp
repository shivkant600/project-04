<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.MarksheetCtl"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
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

	<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.MarksheetBean"
			scope="request" />


		<%
			List studentlist = (List) request.getAttribute("studentlist");
		%>


		<div align="center">
			<h1>Add Marksheet</h1>

			<h3>
				<span style="color: green"><%=ServletUtility.getSuccessMessage(request)%></span>
				<span style="color: red"><%=ServletUtility.getErrorMessage(request)%></span>

			</h3>

			<!-- Hidden Fields -->
			<input type="hidden" name="id" value="<%=bean.getId()%>" /> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>" />
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>" /> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>" />
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>" />


			<table>
				<tr>
					<th>RollNo <span style="color: red">*</span></th>
					<td><input type="text" name="rollno"
						value="<%=DataUtility.getStringData(bean.getRollNo())%>"
						placeholder="EnterName"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("rollno", request)%></font></td>

				</tr>

				<tr>
					<th align="left">Student Name <span style="color: red">*</span></th>
					<td><%=HTMLUtility.getList("studentid", DataUtility.getStringData(bean.getStudentId()), studentlist)%></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("studentid", request)%></font></td>

				</tr>

				<tr>
					<th>Physics <span style="color: red">*</span></th>
					<td><input type="text" name="physics"
						value="<%=DataUtility.getStringData(bean.getPhysics())%>"
						placeholder="EnterName"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("physics", request)%></font></td>

				</tr>

				<tr>
					<th>Chemistry <span style="color: red">*</span></th>
					<td><input type="text" name="chemistry"
						value="<%=DataUtility.getStringData(bean.getChemistry())%>"
						placeholder="EnterName"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("chemistry", request)%></font></td>

				</tr>

				<tr>
					<th>Maths <span style="color: red">*</span></th>
					<td><input type="text" name="maths"
						value="<%=DataUtility.getStringData(bean.getMaths())%>"
						placeholder="EnterName"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("maths", request)%></font></td>

				</tr>

			</table>

			<table>
				<td><input type="submit" name="operation"
					value="<%=MarksheetCtl.OP_SAVE%>"></td>
				<td><input type="submit" name="operation"
					value="<%=MarksheetCtl.OP_RESET%>"></td>

			</table>

		</div>
	</form>
</body>
</html>