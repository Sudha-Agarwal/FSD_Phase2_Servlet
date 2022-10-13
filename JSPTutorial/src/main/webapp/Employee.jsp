<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="emp" class="bean.Employee" scope="request">

<%-- 
<jsp:setProperty property="id" name="emp" value="1"/>
<jsp:setProperty property="firstName" name="emp" value="Sudha"/>
--%>

<jsp:setProperty property="*" name="emp" />

</jsp:useBean>

<p>Employee Details</p>

<p>Emp Id:
<jsp:getProperty property="id" name="emp"/>
<jsp:getProperty property="firstName" name="emp"/>


<jsp:forward page="index.jsp" />
</p>
</body>
</html>