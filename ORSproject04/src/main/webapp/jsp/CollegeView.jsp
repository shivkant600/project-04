<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.CollegeCtl"%>
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

	<form action="<%=ORSView.COLLEGE_CTL%>" method="post">
		<jsp:useBean id="bean" class="in.co.rays.bean.CollegeBean"
			scope="request" />
		<div align="center">

			<%
				if (ServletUtility.getSuccessMessage(request) != null) {
			%>

			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>
			<%} %>

			<%if(bean != null && bean.getId() > 0) {%>

			<h1>Update College</h1>

			<%}else{ %>

			<h1>Add College</h1>

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

					<th>Name<span style="color: red">*</span></th>
					<td><input type="text" name="Name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="Enter CollegeName"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Name", request)%></font></td>

				</tr>
				<tr>
					<th>Address <span style="color: red">*</span></th>
					<td><input type="text" name="Address"
						value="<%=DataUtility.getStringData(bean.getAddress())%>"
						placeholder="Enter Address"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("Address", request)%></font></td>
				</tr>
				<tr>
					<th>State<span style="color: red">*</span></th>
					<td><input type="text" name="State"
						value="<%=DataUtility.getStringData(bean.getState())%>"
						placeholder="Enter State"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("State", request)%></font></td>
				</tr>
				<tr>
					<th>City<span style="color: red">*</span></th>
					<td><input type="text" name="City"
						value="<%=DataUtility.getStringData(bean.getCity())%>"
						placeholder="Enter City"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("City", request)%></font></td>
				</tr>
				<tr>
					<th>Phone No<span style="color: red">*</span></th>
					<td><input type="text" name="PhoneNo"
						value="<%=DataUtility.getStringData(bean.getPhoneNo())%>"
						placeholder="Enter PhoneNo"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("PhoneNo", request)%></font></td>
				</tr>


			</table>

			<table>
				
<%
						if (bean != null && bean.getId() > 0) {
					%>

					<td align="left" colspan="2"><input type="submit"
						name="operation" value="<%=CollegeCtl.OP_UPDATE%>"> <input
						type="submit" name="operation" value="<%=CollegeCtl.OP_CANCEL%>"></td>
						<%
							} else {
						%>
					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_SAVE%>"></td>
					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_RESET%>"></td>
					<%
						}
					%>
					

				


			</table>


		</div>

	</form>

</body>
</html>