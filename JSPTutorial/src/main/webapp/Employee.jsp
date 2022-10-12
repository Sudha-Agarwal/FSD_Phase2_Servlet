<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="emp" class="bean.Employee">
<jsp:setProperty property="id" name="emp" value="1"/>
<jsp:setProperty property="firstName" name="emp" value="Sudha"/>
</jsp:useBean>

<p>Employee Details</p>

<p>Emp Id:
<jsp:getProperty property="id" name="emp"/>

</p>
</body>
</html>