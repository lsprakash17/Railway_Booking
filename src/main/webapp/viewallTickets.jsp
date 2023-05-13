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
<% User user=(User)session.getAttribute("user"); %>
<%if(user==null){
response.getWriter().print("<h1 style='color:red'>Session Expired login again</h1>");	
request.getRequestDispatcher("Login.html").include(request, response);
}
else{
%>
       
      <% TrainTicket train=new TrainTicket(); %>
       <input type="text" name="tname" id="tname" value="<%=train.getPnr()%>" readonly="readonly">
<% }%>
</body>
</html>