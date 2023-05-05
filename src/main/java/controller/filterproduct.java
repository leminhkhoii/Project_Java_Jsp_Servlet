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

/**
 * Servlet implementation class filterproduct
 */
@WebServlet("/filterproduct")
public class filterproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter = request.getParameter("price");
		String txt = request.getParameter("txt");
		productDAO pD = new productDAO();
		List list = new ArrayList<>();
		
		if(filter.equals("1"))
		{
			list = pD.getAllProductByFilter1(txt);
		}
		
		if(filter.equals("2"))
		{
			list = pD.getAllProductByFilter2(txt);
		}
		System.out.println("txt: "+txt);
		request.setAttribute("txtsearch", txt);
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/manageproduct.jsp");
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
