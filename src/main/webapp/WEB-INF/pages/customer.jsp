<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Customer</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color: #ff3331;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Customer
</h1>

<c:url var="addAction" value="/customer/add" ></c:url>

<form:form action="${addAction}" commandName="customer">
<table>
	<c:if test="${!empty customer.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="code">
				<spring:message text="Code"/>
			</form:label>
		</td>
		<td>
			<form:input path="code" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="nicNo">
				<spring:message text="NIC No"/>
			</form:label>
		</td>
		<td>
			<form:input path="nicNo" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="address" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="telNo">
				<spring:message text="Tel No"/>
			</form:label>
		</td>
		<td>
			<form:input path="telNo" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="fax">
				<spring:message text="Fax"/>
			</form:label>
		</td>
		<td>
			<form:input path="fax" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty customer.name}">
				<input type="submit"
					value="<spring:message text="Edit Customer"/>" />
			</c:if>
			<c:if test="${empty customer.name}">
				<input type="submit"
					value="<spring:message text="Add Customer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Customer List</h3>
<c:if test="${!empty listCustomer}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Code</th>
		<th width="120">Name</th>
		<th width="120">NIC No</th>
		<th width="120">Address</th>
		<th width="120">Tel No</th>
		<th width="120">Fax</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCustomer}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.code}</td>
			<td>${customer.name}</td>
			<td>${customer.nicNo}</td>
			<td>${customer.address}</td>
			<td>${customer.telNo}</td>
			<td>${customer.fax}</td>
			<td><a href="<c:url value='/customer/edit/${customer.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/customer/remove/${customer.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
