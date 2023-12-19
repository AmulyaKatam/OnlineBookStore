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
out.println("Page Belongs to :"+cb.getFname()+"<br>");
BookBean bb = (BookBean)request.getAttribute("bbean");
out.println("Code: "+bb.getCode()+"<br>"+"BookName: "+bb.getName()+"<br>"+"Author: "+bb.getAuthor()+"<br>"
		+"Price: "+bb.getPrice()+"<br>"+"Qty: "+bb.getQty()+"<br>");

%>
<form action="purchase" method="post">
<input type="hidden" name="pcode" value=<%=bb.getCode() %>><br>
Enter Required Qty:<input type="text" name="pqty"><br>
<input type="submit" value="Buy">

</form>

</body>
</html>