<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.ClientCtl"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
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

	<form action="<%=ORSView.CLIENT_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.ClientBean"
			scope="request" />


		<div align="center">
			<table>


				<h3>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>
				<h1>ADD Client</h1>

				<tr>
					<td><input type="hidden" name="id" placeholder="enter id">
					</td>
				</tr>


				<tr>
					<th align="left">Full Name<span style="color: red">*</span></th>
					<td><input type="text" name="fullName"
						placeholder="enter fullname"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("fullName", request)%></font></td>
				</tr>


				<tr>
					<th align="left">Appoinment Date<span style="color: red">*</span></th>
					<td><input type="text" id="udate" name="appoinmetDate"
						placeholder="enter appoinmentdate"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("dob", request)%></font></td>

				</tr>



				<tr>
					<th align="left">phoneNo<span style="color: red">*</span></th>
					<td><input type="text" name="phoneNo"
						placeholder="enter phoneNo"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></font></td>


				</tr>



				<tr>
					<th align="left">illness<span style="color: red">*</span></th>
					<td>
						<%
							HashMap<String, String> illnessMap = new HashMap<>();
							illnessMap.put("weakness", "weakness");
							illnessMap.put("cancer", "cancer");
							illnessMap.put("tumer", "tumer");
							illnessMap.put("stomatchpain", "stomatchpain");
						%> <%=HTMLUtility.getList("illness", bean.getIllness(), illnessMap)%>


					</td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("illness", request)%></font></td>

				</tr>

			</table>
			<table>
				<tr>
					<td><input type="submit" name="operation"
						value="<%=ClientCtl.OP_SAVE%>"> <input type="submit"
						name="operation" value="<%=ClientCtl.OP_RESET%>"></td>

				</tr>


			</table>
		</div>
	</form>

</body>
</html>