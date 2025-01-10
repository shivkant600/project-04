
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.ctl.PurchaseCtl"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
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

	<form action="<%=ORSView.PURCHASE_CTL%>" method="post">
		<jsp:useBean id="bean" class="in.co.rays.bean.PurchaseBean"
			scope="request" />



		<div align="center">

			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h1>Update Purchase</h1>

			<%
				} else {
			%>

			<h1>Add Purchase</h1>
			<%
				}
			%>

			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
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


					<th align="left">Quantity<span style="color: red">*</span></th>
					<td><input type="text" name="quantity"
						placeholder="Enter Quantity"
						value="<%=DataUtility.getStringData(bean.getQuantity())%>" /></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("quantity", request)%></font></td>




				</tr>

				<tr>


					<th align="left">Price<span style="color: red">*</span></th>
					<td><input type="text" name="price" placeholder="Enter price"
						value="<%=DataUtility.getStringData(bean.getPrice())%>" /></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("price", request)%></font></td>



				</tr>

				<tr>


					<th align="left">PurchaseDate<span style="color: red">*</span></th>
					<td><input type="text" name="purchasedate" id="update"
						placeholder="Enter PurchaseDate"
						value="<%=DataUtility.getStringData(bean.getPurchasedate())%>" /></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("purchasedate", request)%></font></td>



				</tr>

				<tr>


					<th align="left">OrderType<span style="color: red">*</span></th>

					<td>
						<%
							HashMap<String, String> ordertypemMap = new HashMap<>();
							ordertypemMap.put("Hp", "Hp");

							ordertypemMap.put("Asus", "Asus");
							ordertypemMap.put("Dell", "Dell");
							ordertypemMap.put("Lenovo", "Lenovo");
						%> <%=HTMLUtility.getList("ordertype", bean.getOrdertype(), ordertypemMap)%>



					</td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("ordertype", request)%></font></td>




				</tr>







			</table>

			<table>
				<tr>

					<%
						if (bean != null && bean.getId() > 0) {
					%>

					<td align="left" colspan="2"><input type="submit"
						name="operation" value="<%=PurchaseCtl.OP_UPDATE%>"> <input
						type="submit" name="operation" value="<%=PurchaseCtl.OP_CANCEL%>">
						<%
							} else {
						%>
					<td><input type="submit" name="operation"
						value="<%=PurchaseCtl.OP_SAVE%>"></td>
					<td><input type="submit" name="operation"
						value="<%=PurchaseCtl.OP_RESET%>"></td>
					<%
						}
					%>

				</tr>
			</table>





		</div>

	</form>

</body>
</html>