<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User user= (User)session.getAttribute("user"); %>
<% if(user==null){
out.print("<h1>Session Expired Loggin again</h1>");
request.getRequestDispatcher("Login.html").include(request, response);
} else {%>
<h1>Add Money To wallet</h1>
<form action="">
Enter the Amount To add:
<input type="number" name="number"><br>
<button>Add</button>
</form>
<a href="UserHome.html"><button>HOME</button></a>
<%} %>

</body>
</html>