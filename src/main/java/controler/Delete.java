package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int num=Integer.parseInt(req.getParameter("id"));
			TrainDao dao=new TrainDao();
			dao.Delete(num);
			resp.getWriter().print("<h1>data deleted successfully</h1>");

			req.setAttribute("train", dao.Fetchall());
			req.getRequestDispatcher("Fetch.jsp").include(req, resp);
			
		}
	
}
