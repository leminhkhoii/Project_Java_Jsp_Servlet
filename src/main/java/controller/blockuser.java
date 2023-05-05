package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.customerDAO;
import model.customer;

/**
 * Servlet implementation class blockuser
 */
@WebServlet("/blockuser")
public class blockuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public blockuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_c");
		int id_c = Integer.parseInt(id);
		customerDAO cD = new customerDAO();
		customer c = cD.selectByIdWithStatus(id_c);
		if(c.getStatus()!=1)
		{
			c.setStatus(1);
			cD.updateStatus(c);
		}
		else
		{
			c.setStatus(0);
			cD.updateStatus(c);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/loaduserad");
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
