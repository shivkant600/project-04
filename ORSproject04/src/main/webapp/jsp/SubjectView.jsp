<%@page import="in.co.rays.ctl.SubjectCtl"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
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

	<form action="<%=ORSView.SUBJECT_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.SubjectBean"
			scope="request" />

		<div align="center">

			<h1>Add Subject</h1>

			<%
				List courselist = (List) request.getAttribute("courselist");
			%>

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
					<th>Name <span style="color: red">*</span></th>
					<td><input type="text" name="name" placeholder="Enter Name"
						value="<%=DataUtility.getStringData(bean.getName())%>"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>

				</tr>

				<tr>
					<th align="left">CourseName <span style="color: red">*</span></th>
					<td><%=HTMLUtility.getList("courseid", DataUtility.getStringData(bean.getCourseId()), courselist)%></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("courseid", request)%></font></td>

				</tr>

				<tr>
					<th>Description <span style="color: red">*</span></th>
					<td><input type="text" name="description"
						placeholder="Enter Description"
						value="<%=DataUtility.getStringData(bean.getDescription())%>"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("description", request)%></font></td>

				</tr>

			</table>

			<table>
				<td><input type="submit" name="operation"
					value="<%=SubjectCtl.OP_SAVE%>"></td>
				<td><input type="submit" name="operation"
					value="<%=SubjectCtl.OP_RESET%>"></td>

			</table>

		</div>
	</form>
</body>
</html>