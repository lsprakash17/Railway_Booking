<!DOCTYPE html>
<%@page import="dto.Train"%>
<%@page import="dao.TrainDao"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Train</title>
<link rel="stylesheet" href="EditTrain.css">
</head>
<body>
    <h1>Edit Train</h1>
    <%
	int num= Integer.parseInt(request.getParameter("num"));
    TrainDao dao=new TrainDao();
    Train train =dao.find(num);
%>
    <form action="update" method="post">
        <label for="tnumber">Train Number:</label>
        <input type="number" name="tnumber" id="tnumber" value="<%=num %>" readonly="readonly">
        <label for="tname">Train Name:</label>
        <input type="text" name="tname" id="tname" value="<%=train.getName()%>">
        <label for="tseat">Number of Seats:</label>
        <input type="number" name="tseat" id="tseat" value="<%=train.getSeat()%>">
        <label for="tstation">Stations:</label>
        <textarea rows="5" cols="30" name="tstation" id="tstation">
            <% for(String station:train.getStations()){
                    out.print(station+",");
                } %>
        </textarea>
        <label for="tprice">Ticket Price:</label>
        <textarea rows="5" cols="30" name="tprice" id="tprice">
            <% for(String price:train.getPrice()){
                    out.print(price+",");
                } %>
        </textarea>
        <label for="ttime">Time:</label>
        <textarea rows="5" cols="30" name="ttime" id="ttime">
            <% for(String Time:train.getTime()){
                    out.print(Time+",");
                } %>
        </textarea>
        <label for="tday">Days:</label>
        <textarea rows="5" cols="30" name="tday" id="tday">
            <% for(String Days:train.getDays()){
                    out.print(Days+",");
                } %>
        </textarea>
        <button type="reset">Cancel</button>
        <button>Update</button>
    </form>
</body>
</html>
