<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Train Information</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
        font-family: Arial, sans-serif;
        font-size: 14px;
    }
    th, td {
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #555;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    button {
        background-color: #008CBA;
        border: none;
        color: white;
        padding: 8px 14px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        margin: 4px 2px;
        cursor: pointer;
    }
</style>
</head>
<body>
<%List<Train> train=(List<Train>)request.getAttribute("train"); %>
<table border="1">
<tr>
<th>Train Number</th>
<th>Train Name</th>
<th>From Station</th>
<th>To Station</th>
<th>Stations</th>
<th>Time of Departure</th>
<th>Time of Arrival</th>
<th>Ticket Price</th>
<th>Available Days</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<% for(Train Tr:train) { %>
<tr>
<th><%=Tr.getNumber() %></th>
<th><%=Tr.getName()%></th>
<th><%=Tr.getStations()[0]%></th>
<th><%=Tr.getStations()[Tr.getStations().length-1]%></th>
<th><%=Arrays.toString(Tr.getStations())%></th>
<th><%=Tr.getTime()[0]%></th>
<th><%=Tr.getTime()[Tr.getTime().length-1]%></th>
<th><%=Arrays.toString(Tr.getPrice()) %></th>
<th><%=Arrays.toString(Tr.getDays()) %></th>
<th><a href="delete?id=<%=Tr.getNumber() %>"><button>Delete</button></a></th>
<th><a href="Edit.jsp?num=<%=Tr.getNumber()%>"><button>Edit</button></a></th>
</tr>
<%}%>
</table>
</body>
</html>
