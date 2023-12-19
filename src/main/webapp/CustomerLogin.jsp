<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
text-align:center;
}
</style>
</head>
<body>

<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
out.println("Welcome Customer: "+cb.getFname()+"<br>");
%>
<a href="view2">ViewAllBooks</a><br>
<a href="logout">Logout</a>

</body>
</html>