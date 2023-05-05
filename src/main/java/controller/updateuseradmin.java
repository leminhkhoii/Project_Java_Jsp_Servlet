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
 * Servlet implementation class updateuseradmin
 */
@WebServlet("/updateuseradmin")
public class updateuseradmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuseradmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accountName = request.getParameter("account");
		String password = request.getParameter("password");
		String mail = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("descr");
		//String id = request.getParameter("id_c");
		System.out.println("password: "+password);
		System.out.println("accountname: "+accountName);
		customerDAO cD = new customerDAO();
		customer c = new customer("", "", address, accountName, password, phone, mail, "");
		cD.update(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
