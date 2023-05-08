package controler;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;
import dto.User;

@WebServlet("/Usertraininfo")
public class FetchUserTrain extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user =(User)req.getSession().getAttribute("user");
		if(user==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session expired Login Again</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);	
		}
		
		else {
		
		TrainDao dao = new TrainDao();
		List<Train> train = dao.Fetchall();
		if (train.isEmpty()) {

			resp.getWriter().print("<h1 style='color:red'>No information available</h1>");
			req.getRequestDispatcher("UserHome.html").include(req, resp);
		} else {
			req.setAttribute("train", train);
			req.getRequestDispatcher("Userfetch.jsp").forward(req, resp);
		}
	}
	}
	
}