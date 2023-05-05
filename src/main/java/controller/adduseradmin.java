package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.customerDAO;
import model.customer;

/**
 * Servlet implementation class adduseradmin
 */
@WebServlet("/adduseradmin")
public class adduseradmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduseradmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountName = request.getParameter("accountname");
		String passWord = request.getParameter("password");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String name = request.getParameter("name");
		String mail = request.getParameter("email");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		
		customer c = new customer(id, name, address, accountName, passWord, phone, mail, gender);
		customerDAO cD = new customerDAO();
		cD.insert(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
