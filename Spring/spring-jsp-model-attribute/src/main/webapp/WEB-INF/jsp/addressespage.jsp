<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Addresses</h1>

<table>
	<tr>
		<td width="100">Id</td>
		<td width="150">Street</td>
		<td width="150">City</td>
		<td width="150">Zip Code</td>
	</tr>
	<c:forEach items="${addresses}" var="address">
		<tr>
			<td><c:out value="${address.id}" /></td>
			<td><c:out value="${address.street}" /></td>
			<td><c:out value="${address.city}" /></td>
			<td><c:out value="${address.zipCode}" /></td>
		</tr>
	</c:forEach>
</table>

<p>${greetings}</p>
</body>
</html>