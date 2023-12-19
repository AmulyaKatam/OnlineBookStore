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
BookBean bb = (BookBean)request.getAttribute("bbean");
out.println("Page Belongs to: "+ab.getFname()+"<br>");
%>
<form action="updateBook" method="post">
<input type="hidden" name="bcode" value=<%=bb.getCode() %>><br>
BookPrice:<input type="text" name="bprice" value="<%=bb.getPrice()%>"><br>
BookQty:<input type="text" name="bqty" value="<%=bb.getQty()%>"><br>
<input type="submit" value="UpdateBook"> 
</form>



</body>
</html>