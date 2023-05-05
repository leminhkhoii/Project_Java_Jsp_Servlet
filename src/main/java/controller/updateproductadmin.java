package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.productDAO;
import database.sizeDAO;
import model.product;
import model.size;

/**
 * Servlet implementation class updateproductadmin
 */
@WebServlet("/updateproductadmin")
@MultipartConfig
public class updateproductadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateproductadmin() {
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
		String nameProduct = request.getParameter("name");
		String nameproducer = request.getParameter("nameproducer");
		String des = request.getParameter("descr");
		String price = request.getParameter("price");
		double pricee = Double.parseDouble(price);
		String id_producttype = request.getParameter("cate");
		String id_product = request.getParameter("id");
		String url = request.getParameter("img");
		String quantity = request.getParameter("quantity");
		int q = Integer.parseInt(quantity);
		
		String nameSize = request.getParameter("nameSize");
		sizeDAO sD = new sizeDAO();
		size s1 = sD.selectByNameSize(nameSize);
		
		if(url!=null)
		{
			Part part = request.getPart("img");
			String realPath = request.getServletContext().getRealPath("/images");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Path.of(realPath)))
			{
				Files.createDirectory(Path.of(realPath));
			}
			product p = new product(id_product, nameProduct, pricee, "001", id_producttype , des, "images/"+fileName);
			System.out.println(realPath+"/"+fileName);
			part.write(realPath+"/"+fileName);
			productDAO pD = new productDAO();
			pD.update(p);
		}
		else
		{
			product p = new product(id_product, nameProduct, pricee, "001", id_producttype , des, "");
			productDAO pD = new productDAO();
			pD.updatewithoutimg(p,s1.getId_size(),q);
		}
	}

}
