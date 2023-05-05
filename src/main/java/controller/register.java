package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.customerDAO;
import model.customer;
import util.MaHoa;

/**
 * Servlet implementation class register
 */
@WebServlet("/do-register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountName = request.getParameter("accountName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		
		request.setAttribute("accountName", accountName);
		request.setAttribute("passWord", passWord);
		request.setAttribute("email", email);
		
		String url="";
		String error="";
		customerDAO cD = new customerDAO();
		if(cD.checkAccountName(accountName))
		{
			error+="Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br>";
		}
		
		request.setAttribute("error", error);

		
		if(error.length()>0) {
			url="/account.jsp";
		}
		else {
			//Random rd1 = new Random();
			//String id_customer= System.currentTimeMillis()+rd1.nextInt(100)+"";
			customer c1 = cD.selectTopCustomer();
			String id = c1.getid_customer();
			int id_c = Integer.parseInt(id)+1;
			String id_customer = String.valueOf(id_c);
			passWord = MaHoa.toSHA1(passWord);
			
			customer c = new customer(id_customer, "", "", accountName, passWord, "", email, "");
			cD.insert(c);
			url="/success.jsp";
		}
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
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
