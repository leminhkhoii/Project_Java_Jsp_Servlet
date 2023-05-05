package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class updateuser
 */
@WebServlet("/updateuser")
public class updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession	session = request.getSession();
		
		int i=1;
		session.setAttribute("flag", i);
		String id = request.getParameter("id_c");
		int id_c = Integer.parseInt(id);
		customerDAO cD = new customerDAO();
		customer c = cD.selectById(id_c);
		
		List<customer> list = cD.getAllCustomer();
		request.setAttribute("account", c.getAccountName());
		request.setAttribute("password", c.getPassWord());
		request.setAttribute("mail", c.getEmail());
		request.setAttribute("phone", c.getPhone());
		request.setAttribute("address", c.getAddress());
		request.setAttribute("id_c", id);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/manageuser.jsp");
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
