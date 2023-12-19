package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/edit")

public class EditBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
		else {
			String bcode = req.getParameter("bcode");
			@SuppressWarnings("unchecked")
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("list");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bcode.equals(bb.getCode())) {
					break;
				}
			}
			req.setAttribute("bbean", bb);
			req.getRequestDispatcher("EditBook.jsp").forward(req, res);
			
		}
		
		
	}

}
