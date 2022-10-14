<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><th>ID</th><th>Name</th><th>Email</th><th>Country</th></tr>

<c:forEach var="user" items="${listUser}">

<tr>
<td><c:out value="${user.id}"/></td>
<td><c:out value="${user.name}"/></td>
<td><c:out value="${user.email}"/></td>
<td><c:out value="${user.country}"/></td>

</c:forEach>

</table>

</body>
</html>