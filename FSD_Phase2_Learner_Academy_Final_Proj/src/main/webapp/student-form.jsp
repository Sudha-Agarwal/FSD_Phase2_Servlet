<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/simplilearn" user="root" password="root" />

	<sql:query dataSource="${db}" var="ListClasses">
	select * from class;
	</sql:query>

	<center>
		<form action="addNewStudent" method="post">

			Student Name: <input type="text" name="studentName" required>
			Class Name: <select name="classes">
				<c:forEach items="${ListClasses.rows}" var="classes">
					<option value="${classes.class_id}">${classes.class_name}</option>
				</c:forEach>
			</select> <input type="submit" value="submit">
	</center>
</body>
</html>