<%@page import="java.util.List"%>
<%@page import="dto.TrainTicket"%>
<%@page import="dto.Train"%>
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
	<%
	User user = (User) session.getAttribute("user");
	%>
	<%
	if (user == null) {
		response.getWriter().print("<h1 style='color:red'>Session Expired login again</h1>");
		request.getRequestDispatcher("Login.html").include(request, response);
	} else {
	%>
	<% List<TrainTicket> list=user.getTickets();
	  if(list==null||list.isEmpty())
	  {
		  response.getWriter().print("<h1 style='color:red'> No tickets Booked</h1>");
		  request.getRequestDispatcher("UserHome.html").include(request, response);
	  }
	 else {%>
	
	<table border="1">
		<tr>
			<th>PNR</th>
			<th>Train Number</th>
             <th>UserName</th>
             <th>From</th>
             <th>To</th>
             <th>Number of Seats</th>
             <th>Price</th>
             <th>DOJ</th>
             <th>DOB</th>
             <th>Status</th>		
		</tr>
		<% for(TrainTicket ticket:list){ %>
			<tr>
			<th><%=ticket.getPnr()%></th>
			<th><%=ticket.getTrainnum()%></th>
             <th><%=user.getFname() + " "+user.getLname()%></th>
             <th><%=ticket.getSource()%></th>
             <th><%=ticket.getDestination() %></th>
             <th><%=ticket.getNUmberOfSeats()%></th>
             <th><%=ticket.getAmt()%></th>
             <th><%=ticket.getDoj()%></th>
             <th><%=ticket.getDob()%></th>
             <th><%=ticket.getStatus()%></th>			
		</tr>
		<tr>
		<th>
		<%if(ticket.getStatus().equals("booked")){ 
		%>
        	<a href="cancel.jsp?pnr=<%=ticket.getPnr()%>"><button>cancel</button></a>	
		<%} else{%>
		    
		<%}} %>
		</th>
		</tr>
	</table>
	<%
	}}
	%>
</body>
</html>