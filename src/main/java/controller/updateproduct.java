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

import database.producerDAO;
import database.productDAO;
import database.product_sizeDAO;
import database.producttypeDAO;
import database.sizeDAO;
import model.producer;
import model.product;
import model.product_sizee;
import model.producttype;
import model.size;

/**
 * Servlet implementation class updateproduct
 */
@WebServlet("/updateproduct")
public class updateproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateproduct() {
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
		String id_product = request.getParameter("id_p");
		productDAO pD = new productDAO();
		product p = pD.selectByIdProduct(id_product);
		List<product> list = pD.getAllProductWithSize();
		request.setAttribute("name", p.getNameProduct());
		request.setAttribute("price", p.getPrice());
		request.setAttribute("id", id_product);
		request.setAttribute("des", p.getDescription());
		
		String nameSize = request.getParameter("nameSize");
		sizeDAO sD = new sizeDAO();
		size s1 = sD.selectByNameSize(nameSize);
		request.setAttribute("nameSize", nameSize);
		
		
		product_sizeDAO pzD = new product_sizeDAO();
		product_sizee pzs = pzD.selectByIdProductAndIdSize(id_product, s1.getId_size());
		int q = pzs.getQuantity();
		request.setAttribute("quantity", q);
		
		
		producerDAO prD = new producerDAO();
		producer pr = prD.selectByIdProducer(p.getid_producer());
		request.setAttribute("producer", pr.getNameProducer());
		
		producttypeDAO prtD = new producttypeDAO();
		producttype prt = prtD.selectByIdProducttype(p.getId_producttype());
		request.setAttribute("producttype", prt.getId_producttype());
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/manageproduct.jsp");
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
