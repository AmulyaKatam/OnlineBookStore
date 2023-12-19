package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/Login")

public class CustomerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		CustomerBean cb = new CustomerLoginDAO().login(req.getParameter("name"), req.getParameter("pword"));
		
		if(cb==null) {
			req.setAttribute("msg", "Invalid Customer Login...<br>");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
		
		
		
	}

}
