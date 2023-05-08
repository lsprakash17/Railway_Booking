package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dto.User;

@WebServlet("/login")
public class LoginUser extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int userid=Integer.parseInt(req.getParameter("userid"));
	String password=req.getParameter("password");
	Userdao userdao=new Userdao();
	User user=userdao.find(userid);
	if(user==null)
	{
		resp.getWriter().print("<h1 style='color:red'>Invalid Id</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);	
	}
	else
	{
		if(user.getPassword().equals(password))
		{
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("user", user);
			resp.getWriter().print("<h1 style='color:green'>Login Successfull</h1>");
			req.getRequestDispatcher("UserHome.html").include(req, resp);	
		}
		else
		{
			resp.getWriter().print("<h1 style='color:red'>Invalid password</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}
}
