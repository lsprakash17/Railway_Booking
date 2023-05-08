package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String trainname = req.getParameter("tname");
		int trainseat = Integer.parseInt(req.getParameter("tseat"));
		String station = req.getParameter("tstation");
		String[] trainstations = station.split(",");
		String price = req.getParameter("tprice");
		String[] trainprice = price.split(",");
		String time = req.getParameter("ttime");
		String[] traintime = time.split(",");
		String days = req.getParameter("tday");
		String[] traindays = days.split(",");

		Train train = new Train();
		train.setSeat(trainseat);
		train.setTime(traintime);
		train.setDays(traindays);
		train.setName(trainname);
		train.setPrice(trainprice);
		train.setStations(trainstations);
		TrainDao dao = new TrainDao();

		dao.Update(train);
		resp.getWriter().print("<h1>successfull update</h1>");
		req.getRequestDispatcher("Fetch.jsp").include(req, resp);
	}
}
