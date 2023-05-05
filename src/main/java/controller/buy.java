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

import database.productDAO;
import database.product_sizeDAO;
import database.sizeDAO;
import model.cart;
import model.item;
import model.product;
import model.product_sizee;
import model.size;

/**
 * Servlet implementation class buy
 */
@WebServlet("/buy")
public class buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		cart c = null;
		Object o =session.getAttribute("cart");
		// nếu có giỏ hàng rồi
		if(o!=null)
		{
			c=(cart)o;
		}else {
			c = new cart();
		}
		String tnum = request.getParameter("num");
		String tid = request.getParameter("pid");
		String tsize = request.getParameter("size");
		
		int num;
		try {
			num = Integer.parseInt(tnum);
			product_sizeDAO pzD = new product_sizeDAO();
			sizeDAO sD = new sizeDAO();
			size s = sD.selectByNameSize(tsize);
			product_sizee pz = pzD.selectByIdProductAndIdSize(tid,s.getId_size());
			productDAO pD =new productDAO();
			product p = pD.selectByIdProduct(tid);
			double price = p.getPrice();
			item i = new item(p, num, price, pz, s);
			c.addItem(i);
			
		} catch (Exception e) {
			num=1;
			tsize="S";
		}
		double totalprice = c.getTotalMoney();
		List<item> list = c.getItems();
		session.setAttribute("cart", c);
		session.setAttribute("sl", list.size());
		session.setAttribute("total", totalprice);
		RequestDispatcher rd = request.getRequestDispatcher("loadsanpham");
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
