<%@page import="dto.Train"%>
<%@page import="dao.TrainDao"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Ticket</title>
</head>
<body>
<% User user=(User)session.getAttribute("user"); %>
<%if(user==null){
response.getWriter().print("<h1 style='color:red'>Session Expired login again</h1>");	
request.getRequestDispatcher("Login.html").include(request, response);
}
else{
%>
<h1>Hello <%= user.getFname()+" "+user.getLname() %></h1>
<%
int TrainNum=Integer.parseInt(request.getParameter("tn"));
TrainDao dao=new TrainDao();
Train train=dao.find(TrainNum);
if(train==null)
{
	response.getWriter().print("<h1 style='color:red'>No Train available on this Number</h1>");
	request.getRequestDispatcher("UserHome.html").include(request, response);
}
else{%>
<h1>Hello <%= user.getFname()+" "+user.getLname() %></h1>
<br>
<form action="bookticket" method="post">
UserID:<input type="text"  name="uid" value="<%=user.getId()%>" readonly="readonly"><br>
TrainNumber:<input type="text" name="tn"value="<%=TrainNum%>" readonly="readonly"><br>
From:
<select name="from">
<% for(int i=0;i<train.getStations().length-1;i++){%>
<option><%=train.getStations()[i] %></option>
<%} %>
</select><br>
To:
<select name="to">
<% for(int i=1;i<train.getStations().length;i++){%>
<option><%=train.getStations()[i] %></option>
<%} %>
</select><br>
Date of Journey:<input type="date" name="doj"><br>
Number Of Seats:<input type="text" name="seats"><br>
<button type="reset"> Cancel</button> <button>Book</button>
</form><br>
<a href="UserHome.html"><button>Back</button></a>
<%}} %>
</body>
</html>