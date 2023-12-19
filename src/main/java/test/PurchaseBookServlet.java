package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/purchase")

public class PurchaseBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,
	IOException{
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else {
			String bcode = req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("blist");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bcode.equals(bb.getCode())) {
					break;
				}
			}
			int qty = Integer.parseInt(req.getParameter("pqty"));
			int qty1 = bb.getQty();
			if(qty1<qty) {
				req.setAttribute("msg", "Please Choose a Qty Less than:"+bb.getQty()+"<br>");
				req.getRequestDispatcher("PurchaseError.jsp").forward(req, res);
				
			}
			else {
				int k = new PurchaseBookDAO().update(qty, bcode);
				if(k>0) {
					req.setAttribute("bbean", bb);
					req.getRequestDispatcher("PurchaseBook.jsp").forward(req, res);;
					
				}
			}
			
			
		}
		
	}

}
