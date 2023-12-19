<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Welcome Admin: "+ab.getFname()+"<br>");
%> 
<a href="Book.html">AddBookDetails</a><br>
<a href="view1">ViewAllBooks</a><br>
<a href="logout">Logout</a>

</body>
</html>