package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.productDAO;
import database.product_sizeDAO;
import database.productsizeDAO;
import model.product;
import model.product_sizee;

/**
 * Servlet implementation class addroductadmin
 */
@WebServlet("/addroductadmin")
@MultipartConfig
public class addroductadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addroductadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd = request.getRequestDispatcher("/addproduct.jsp");
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("productName");
			String price = request.getParameter("price");
			double pricee = Double.parseDouble(price);
			String des = request.getParameter("description");
			String cate = request.getParameter("cate");
			String producer = request.getParameter("id_producer");
			String id_size = request.getParameter("id_size");
			String quantity = request.getParameter("quantity");
			int q = Integer.parseInt(quantity);
			System.out.println("id_size: "+id_size);
			System.out.println("q: "+q);
			
			
			Part part = request.getPart("img");
			String realPath = request.getServletContext().getRealPath("/images");
			//String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Path.of(realPath)))
			{
				//Files.createDirectory(Path.of(realPath));
				Files.createDirectories(Paths.get(realPath));
			}
			product p = new product(id, name, pricee, producer, cate, des, "images/"+fileName);
			//product_sizee pz = new product_sizee(id, id_size, q);
			System.out.println(realPath+"/"+fileName);
			part.write(realPath+"/"+fileName);
			productDAO pD = new productDAO();
			pD.insert1(p,id_size,q);
			//productsizeDAO pzD = new productsizeDAO();
			//pzD.insert(pz);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
