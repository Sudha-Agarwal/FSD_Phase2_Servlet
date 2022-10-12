<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" session="true" isErrorPage = "true"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Next JSP</p>
<% String name = (String)session.getAttribute("user"); %>
<%="Hello " + name %>

<% String name1 = (String)pageContext.getAttribute("user",pageContext.SESSION_SCOPE); %>
<%="Hello " + name1 %>

<%= new Date()%>
</body>
</html>