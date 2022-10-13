<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="login.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
<p>Hello World</p>
<%-- Scriptlet --%>
<% out.println("Hello World"); %>
<br>
<%="Hello World" %> <%--Expression element --%>

<%--JSP comment --%>

<!-- HTML comment -->

<%--Declaration element --%>
<%! int x = 62; int y=20; %>
<%out.print("value of x is " + x); %>
<%= "value of y is " + y %>

<p>
<%!
	int sum(int num1, int num2){
		return num1+num2;
}
%>
<%= "Sum is " + sum(2,3) %>
</p>



</body>
</html>