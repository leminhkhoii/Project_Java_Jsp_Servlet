package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.orderDAO;
import model.customer;
import model.order;

/**
 * Servlet implementation class updateorderadmin
 */
@WebServlet("/updateorderadmin")
public class updateorderadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateorderadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String o_id = request.getParameter("id_order");
		String order_date = request.getParameter("orderdate");
		String delivery_date = request.getParameter("deliverydate");
		String c_id = request.getParameter("id_customer");
		String total_price = request.getParameter("price");
		String status = request.getParameter("status");
		String method = request.getParameter("method");
		
		int id = Integer.parseInt(o_id);
		double total = Double.parseDouble(total_price);
		order o = new order(id, total, status, c_id, method, order_date, delivery_date);
		orderDAO oD = new orderDAO();
		oD.updateorder(o);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
