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
 * Servlet implementation class search1
 */
@WebServlet("/search1")
public class search1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String txtSearch = request.getParameter("txt");
			String indexString = request.getParameter("index");
			String sort = request.getParameter("sort");
			int index = Integer.parseInt(indexString);
			productDAO pD = new productDAO();
			int count = pD.getCountProductBySearchName(txtSearch);
			int pagesize = 3;
			int endpage = 0;
			endpage = count/pagesize;
			if(count%pagesize!=0)
			{
				endpage++;
			}
			
			List list = new ArrayList<>();
			if(sort.equals("1"))
			list = pD.getProductBySearchNameDividePage(txtSearch, index, pagesize);
			if(sort.equals("2"))
			list = pD.getProductBySearchNameDividePage1(txtSearch, index, pagesize);
			else
				list = pD.getProductBySearchNameDividePage(txtSearch, index, pagesize);
			//System.out.println(list);
			request.setAttribute("txtsearch", txtSearch);
			request.setAttribute("list", list);
			request.setAttribute("end", endpage);
			request.setAttribute("sort", sort);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/products.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
