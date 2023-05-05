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

import database.orderDAO;
import model.order;
import model.product;

/**
 * Servlet implementation class updateorder
 */
@WebServlet("/updateorder")
public class updateorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateorder() {
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
		String id_o = request.getParameter("id_o");
		int id = Integer.parseInt(id_o);
		orderDAO oD = new orderDAO();
		
		order o = oD.selectByIdOrder(id);
		List<order> list = oD.getAllOrder();
		
		request.setAttribute("id_order", id_o);
		request.setAttribute("id_customer", o.getId_customer());
		request.setAttribute("order_date", o.getOrder_date());
		request.setAttribute("deliver_date", o.getDelivery_date());
		request.setAttribute("total", o.getTotal_money());
		request.setAttribute("method", o.getMethod());
		request.setAttribute("status", o.getStatus());
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/manageorder.jsp");
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
