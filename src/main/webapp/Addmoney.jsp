<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Money to Wallet</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			font-size: 16px;
			background-color: #f2f2f2;
		}
		.container {
			max-width: 600px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
			border-radius: 5px;
			text-align: center;
		}
		h1 {
			margin-top: 0;
			font-weight: normal;
		}
		form {
			margin-top: 20px;
			display: inline-block;
			text-align: left;
		}
		input[type="number"] {
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
			width: 100%;
			margin-bottom: 10px;
			box-sizing: border-box;
		}
		button {
			background-color: #4CAF50;
			color: #fff;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			margin-right: 10px;
			transition: background-color 0.3s;
		}
		button:hover {
			background-color: #3e8e41;
		}
		a button {
			background-color: #f44336;
			margin-right: 0;
		}
		a button:hover {
			background-color: #e53935;
		}
	</style>
</head>
<body>
	<div class="container">
		<% User user = (User)session.getAttribute("user"); %>
		<% if (user == null) { %>
			<h1>Session Expired - Login Again</h1>
			<p style="color: red">Your session has expired. Please login again to continue.</p>
			<a href="Login.html"><button>Login</button></a>
		<% } else { %>
			<h1>Add Money to Wallet</h1>
			<form action="addmoney" method="get">
				<label for="amount">Enter Amount to Add:</label><br>
				<input type="number" id="amount" placeholder="Enter the Amount" name="amount">
				<button type="submit">Add</button>
			</form>
			<a href="UserHome.html"><button>Back</button></a>
		<% } %>
	</div>
</body>
</html>
