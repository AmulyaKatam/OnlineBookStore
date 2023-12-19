package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/view1")

@SuppressWarnings("serial")
public class ViewBooksServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,
	IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			ArrayList<BookBean> al = new ViewBooksDAO().retrieve();
			hs.setAttribute("list", al);
			req.getRequestDispatcher("ViewBooks.jsp").forward(req, res);
		}
		
	}

}
