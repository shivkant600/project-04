<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.CourseCtl"%>
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

	<%@include file="Header.jsp"%>

	<form action="<%=ORSView.COURSE_CTL%>" method="post">
		<jsp:useBean id="bean" class="in.co.rays.bean.CourseBean"
			scope="request" />

		<div align="center">
			<h1>Add Course</h1>
			<%if(ServletUtility.getSuccessMessage(request) != null){ %>
			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>
			<%} %>


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
					<td><input type="text" name="Name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="Enter Name"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Name", request)%></font></td>





				</tr>

				<tr>

					<th>Duration <span style="color: red">*</span></th>
					<td><input type="text" name="Duration"
						value="<%=DataUtility.getStringData(bean.getDuration())%>"
						placeholder="Enter Duration"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Duration", request)%></font></td>


				</tr>


				<tr>

					<th>Description <span style="color: red">*</span></th>
					<td><input type="text" name="Description"
						value="<%=DataUtility.getStringData(bean.getDescription())%>"
						placeholder="Enter Description"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Description", request)%></font></td>


				</tr>


			</table>


			<table>
				<th></th>

				<td><input type="submit" name="operation"
					value="<%=CourseCtl.OP_SAVE%>"></td>

				<td><input type="submit" name="operation"
					value="<%=CourseCtl.OP_RESET%>"></td>


			</table>





		</div>

	</form>

</body>
</html>