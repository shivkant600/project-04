<%@page import="in.co.rays.util.ServletUtility"%>
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


	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<center>
			<br> <br>
			<h1>User login</h1>
			<table>
				<tr>

					<th>Login :</th>
					<td><input type="email" name="login" placeholder="enter login"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font></td>
					
				</tr>



				<tr>
					<th>Password :</th>

					<td><input type="password" name="password"
						placeholder="enter password"></td>
						<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("password", request)%></font></td>
						
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignIn"></td>
				</tr>
			</table>
		</center>
	</form>
	<%@include file="Footer.jsp" %>
</body>
</html>