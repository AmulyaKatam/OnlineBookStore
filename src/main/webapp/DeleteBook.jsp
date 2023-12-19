<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
String msg = (String)request.getAttribute("msg");
out.println("Page Belongs to:"+ab.getFname()+"<br>");
out.println(msg);
%>
<a href="Book.html">AddBookDetails</a><br>
<a href="view1">ViewAllBooks</a><br>
<a href="logout">Logout</a>

</body>
</html>