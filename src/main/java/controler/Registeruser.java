package controler;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import dto.User;

@WebServlet("/register")
public class Registeruser extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String Fname=req.getParameter("first");
	String lname=req.getParameter("last");
	long mobile=Long.parseLong(req.getParameter("mobile"));
	String email=req.getParameter("email");
	String gender=req.getParameter("gender");
	String password1=req.getParameter("password1");
	String password2=req.getParameter("password2");
    Date dob=Date.valueOf(req.getParameter("dob"));
    int age= Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
	
	if(password1.equals(password2))
	{
		if(age>18)
		{
			User user=new User();
			user.setFname(Fname);
			user.setLname(lname);
			user.setAge(age);
			user.setDob(dob);
			user.setMobile(mobile);
			user.setEmail(email);
			user.setGender(gender);
			user.setPassword(password2);
			
			Userdao userdao=new Userdao();
			userdao.save(user);
			resp.getWriter().print("<h1 style='color:green'>Account Created Success</h1>");
			resp.getWriter().print("<h1 style='color:blue'>Your UserId is : "+user.getId()+" </h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>You are not old</h1>");
			req.getRequestDispatcher("Register.html").include(req, resp);
		}
	}
	else
	{
		resp.getWriter().print("<h1 style='color:red'>Password miss match</h1>");
		req.getRequestDispatcher("Register.html").include(req, resp);
	}
}
}
