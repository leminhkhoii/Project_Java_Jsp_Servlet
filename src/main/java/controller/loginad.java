package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.customerDAO;
import model.customer;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginad")
public class loginad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountName = request.getParameter("accountName1");
		String passWord = request.getParameter("passWord1");
		
		customer c = new customer();
		c.setAccountName(accountName);
		c.setPassWord(passWord);
		
		customerDAO cD = new customerDAO();
		customer c1 = cD.selectByUsernameAndPassWord(c);
		String url="";
		if(c1!=null)
		{
			HttpSession	session = request.getSession();
			session.setAttribute("Customer", c1);
			url="/adminhome.jsp";
		}
		else
			url="/login_admin.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
