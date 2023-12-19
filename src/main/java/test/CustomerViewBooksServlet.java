package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/view2")

public class CustomerViewBooksServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			
			ArrayList<BookBean> al = new ViewBooksDAO().retrieve();
			hs.setAttribute("blist", al);
			req.getRequestDispatcher("CustomerViewBooks.jsp").forward(req, res);
		}
		
	}

}
