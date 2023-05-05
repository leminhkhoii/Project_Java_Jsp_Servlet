package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.orderDAO;
import model.customer;
import model.order;

/**
 * Servlet implementation class accountdetail
 */
@WebServlet("/accountdetail")
public class accountdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object o =session.getAttribute("Customer");
		customer cus = (customer)o;
		List<order>listod = new ArrayList<>();
		List<order>listod1 = new ArrayList<>();
		orderDAO oD = new orderDAO();
		listod = oD.selectByIdCustomer(cus);
		listod1 = oD.selectByIdCustomer1(cus);
		request.setAttribute("listod", listod);
		request.setAttribute("listod1", listod1);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/account-detail.jsp");
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
