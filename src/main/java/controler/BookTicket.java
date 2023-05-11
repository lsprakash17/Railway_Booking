package controler;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dao.Userdao;
import dto.Train;
import dto.TrainTicket;
import dto.User;

@WebServlet("/bookticket")
public class BookTicket extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1 style='color:red'>Session Expired Login Again</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		} else {
			int trainNumber = Integer.parseInt(req.getParameter("tn"));
			TrainDao dao = new TrainDao();
			Train train = dao.find(trainNumber);
			String from = req.getParameter("from");
			String to = req.getParameter("to");
			int numberOfSeats = Integer.parseInt(req.getParameter("seats"));
			Date doj = Date.valueOf(req.getParameter("doj"));
			Date dob = Date.valueOf(LocalDate.now());
			if(numberOfSeats<=0)
			{
				resp.getWriter().print("<h1>Seat can not be less than 1</h1>");
				req.getRequestDispatcher("UserHome.html").include(req, resp);
			}
			else{
			if (from.equals(to)) {
				resp.getWriter().print("<h1>Source and Destination can not be same</h1>");
				req.getRequestDispatcher("UserHome.html").include(req, resp);
			} else {
				int fromPos = 0;
				int toPos = 0;
				for (int i = 0; i < train.getStations().length; i++) {
					if (train.getStations()[i].equals(from)) {
						fromPos = i;
					}
					if (train.getStations()[i].equals(to)) {
						toPos = i;
					}
				}
				if (fromPos > toPos) {
					resp.getWriter().print("<h1>Select Valid Source and Destination</h1>");
					req.getRequestDispatcher("UserHome.html").include(req, resp);
				} else {
					double price = Double.parseDouble(train.getPrice()[toPos])
							- Double.parseDouble(train.getPrice()[fromPos]);
					double amount=numberOfSeats*price;
					
					boolean flag=false;
					for(String day:train.getDays())
					{
						if(day.equalsIgnoreCase(doj.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ENGLISH)))
								{
							flag=true;
								}
					}
					
					if(Period.between(dob.toLocalDate(),doj.toLocalDate()).getDays()<0 || flag)
					{
						resp.getWriter().print("<h1>Train Not Available in the selected date </h1>");
						req.getRequestDispatcher("UserHome.html").include(req, resp);
					}
					else {
						if(user.getWallet()<amount)
						{
							resp.getWriter().print("<h1>Insufficient funds for booking ticket</h1>");
							req.getRequestDispatcher("UserHome.html").include(req, resp);
						}
						else {
							TrainTicket ticket=new TrainTicket();
							ticket.setAmt(amount);
							ticket.setDob(dob);
							ticket.setDoj(doj);
							ticket.setFrom(from);
							ticket.setNUmberOfSeats(numberOfSeats);
							ticket.setTo(to);
							ticket.setTrainnum(trainNumber);
							ticket.setUser(user);
							
							dao.sav(ticket);
							
							List<TrainTicket> ticke=user.getTickets();
							if(ticke==null)
							{
								ticke=new ArrayList<>();
							}
							ticke.add(ticket);
							user.setTickets(ticke);
							Userdao dao2=new Userdao();
							dao2.save(user);
						}
						
					}

				}
			}
		}
		}
	}
}