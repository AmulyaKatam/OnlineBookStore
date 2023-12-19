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
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
out.println("Page Belongs to: "+cb.getFname()+"<br>");
BookBean bb = (BookBean)request.getAttribute("bbean");
int qty = Integer.parseInt(request.getParameter("pqty"));
out.println("Payment Successfull...<br>");
out.println("Amount paid is:"+(bb.getPrice())*qty+"<br>" );

%>
<a href="logout">Logout</a>

</body>
</html>