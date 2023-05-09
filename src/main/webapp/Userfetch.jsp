
<%@page import="java.util.List"%>
<%@page import="dto.Train"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Train> train=(List<Train>)request.getAttribute("train"); %>
<table border="1">
<tr>
<th>Train Number</th>
<th>Train Name</th>
<th>From Station</th>
<th>To Station</th>
<th>Time of Departure</th>
<th>Time of Arrival</th>
<th>Total seats</th>
<th>Available Days</th>
<th>Book</th>
</tr>
<% for(Train Tr:train) { %>
<tr>
<th><%=Tr.getNumber() %></th>
<th><%=Tr.getName()%></th>
<th><%=Tr.getStations()[0]%></th>
<th><%=Tr.getStations()[Tr.getStations().length-1]%></th>
<th><%=Tr.getTime()[0]%></th>
<th><%=Tr.getTime()[Tr.getTime().length-1]%></th>
<th><%=Tr.getSeat()%>></th>
<th><%=Arrays.toString(Tr.getDays()) %></th>
<th><a href="Book.jsp?tn=<%=Tr.getNumber()%>"><button>BOOK</button></a></th>
</tr>
<%}%>
</table>
</body>
</html>