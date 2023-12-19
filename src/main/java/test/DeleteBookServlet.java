package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
//import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/delete")

public class DeleteBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired Successfully...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			String bcode = req.getParameter("bcode");
			//@SuppressWarnings("unchecked")
			//ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("list");
			//BookBean bb = null;
			//Iterator<BookBean> it = al.iterator();
			//while(it.hasNext()) {
				//bb = it.next();
				//if(bcode.equals(bb.getCode())) {
					//break;
				//}
			//}
			int k = new DeleteBookDAO().delete(bcode);
			if(k>0) {
				req.setAttribute("msg", "Book Deleted Successfully...<br>");
				req.getRequestDispatcher("DeleteBook.jsp").forward(req, res);
			}
			
		}
		
	}

}
