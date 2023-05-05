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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("Customer");
		customer c1 = null;
		
		String url="/account-detail.jsp";
		String error="";
		
		if (obj!=null)
			c1 = (customer)obj;
		c1.setName(name);
		c1.setEmail(email);
		c1.setPhone(phone);
		c1.setAddress(address);
		c1.setGender(gender);
		
		customerDAO cD = new customerDAO();
		if(cD.update(c1)>0)
		{
			error+="update success";
		}
		else 
			error=error+"update fail ne"+c1.getAccountName();
		request.setAttribute("error", error);
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
