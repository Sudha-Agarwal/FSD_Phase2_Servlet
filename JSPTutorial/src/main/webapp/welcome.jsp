<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="next.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("userName");
	out.println(name);
%>

<%= "Welcome " + request.getParameter("userName") %>

<% session.setAttribute("user", name); %>

<% pageContext.setAttribute("user", name, pageContext.SESSION_SCOPE); %>

<% response.sendRedirect("next.jsp"); %>




</body>
</html>