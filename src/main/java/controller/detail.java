package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.productDAO;
import database.relatedimgDAO;
import model.product;
import model.relatedimg;

/**
 * Servlet implementation class detail
 */
@WebServlet("/detail")
public class detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		productDAO pD = new productDAO();
		product p = pD.selectByIdProduct(id);
		relatedimgDAO rD = new relatedimgDAO();
		List<relatedimg> list = rD.getAllImg(id);
		request.setAttribute("product", p);
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/product-detail.jsp");
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
