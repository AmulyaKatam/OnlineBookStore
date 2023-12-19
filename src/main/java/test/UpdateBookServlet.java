package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/updateBook")

public class UpdateBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			String bcode = req.getParameter("bcode");
			@SuppressWarnings({ "unchecked" })
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("list");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bcode.equals(bb.getCode())) {
					break;
				}
			}
			bb.setPrice(Float.parseFloat(req.getParameter("bprice")));
			bb.setQty(Integer.parseInt(req.getParameter("bqty")));
			 int k =  new UpdateBookDAO().update(bb);
			 if(k>0) {
				 req.setAttribute("msg","Book Details Updated Successfully...<br>");
				 req.getRequestDispatcher("UpdateBook.jsp").forward(req, res);
			 }
		}
		
	}

}
