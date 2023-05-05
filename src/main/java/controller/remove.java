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

import model.item;

/**
 * Servlet implementation class remove
 */
@WebServlet("/remove")
public class remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		model.cart c = null;
		Object o =session.getAttribute("cart");
		//co roi
		if(o!=null)
		{
			c=(model.cart)o;
		}
		else
			c=new model.cart();
		String id = request.getParameter("p_id");
		c.removeItem(id);
		List<item> list = c.getItems();
		double totalprice = c.getTotalMoney();
		session.setAttribute("cart", c);
		session.setAttribute("sl", list.size());
		session.setAttribute("total", totalprice);
		RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
		rd.forward(request, response);
	}

}
