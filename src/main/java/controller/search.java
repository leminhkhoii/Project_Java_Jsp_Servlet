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

import database.productDAO;
import model.product;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txtSearch = request.getParameter("txt");
		String sortSearch = request.getParameter("sort");
		productDAO pD = new productDAO();
		List list = new ArrayList<>();
		if(sortSearch.equals("Default Sorting"))
		 list = pD.getProductBySearchName(txtSearch);
		else if(sortSearch.equals("Sort by A-Z"))
		 list = pD.getProductByAZName(txtSearch);
		else
			list = pD.getProductByAZName(txtSearch);
		request.setAttribute("txtsearch", txtSearch);
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/products.jsp");
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
