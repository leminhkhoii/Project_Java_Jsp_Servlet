package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.customerDAO;
import database.productDAO;
import model.product;

/**
 * Servlet implementation class addproductad
 */
@WebServlet("/addproductad")
public class addproductad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addproductad() {
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
		System.out.println("hihi");
		//boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//if(!isMultipart)
		//	return;
		try {
			String nameProduct = request.getParameter("productName");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			double price1 = Double.parseDouble(price);
			String id_product = request.getParameter("id");
			
			product p = new product(id_product, nameProduct, price1, "", description, "");
			
			
			String folder = getServletContext().getRealPath("images");
			File file;
			int maxFileSize = 5000*1024;
			int maxMemSize = 5000*1024;
			
			String contentType = request.getContentType();
			
			if(contentType.indexOf(contentType)>=0)
			{
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				// Qui dinh dung luong toi da cho 1 file
				factory.setSizeThreshold(maxMemSize);
				
				// Tao file upload
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(maxFileSize);
				
				List<FileItem> files = upload.parseRequest(request);
				
				for (FileItem fileItem : files) {
					String filename = fileItem.getName();
					String path = folder+"\\"+filename;
					file = new File(path);
					
					fileItem.write(file);
					p.setUrl(filename);
					productDAO pD = new productDAO();
					pD.insert(p);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
