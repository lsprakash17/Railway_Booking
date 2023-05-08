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

@WebServlet("/fetch")
public class FetchAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainDao dao = new TrainDao();
		List<Train> train = dao.Fetchall();
		if (train.isEmpty()) {

			resp.getWriter().print("<h1 style='color:red'>No information available</h1>");
			req.getRequestDispatcher("Managementhome.html").include(req, resp);
		} else {
			req.setAttribute("train", train);
			req.getRequestDispatcher("Fetch.jsp").forward(req, resp);
		}
	}
	
}
