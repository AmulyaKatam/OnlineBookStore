package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/register")

public class CustomerRegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("name"));
		cb.setPword(req.getParameter("pword"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setMid(req.getParameter("mid"));
		cb.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k = new CustomerRegisterDAO().register(cb);
		
		if(k>0) {
			req.setAttribute("msg", "User Registered Successfully...<br>");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
		
	}

}
