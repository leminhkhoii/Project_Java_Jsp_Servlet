package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.customerDAO;
import model.customer;

/**
 * Servlet implementation class changepassword
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassWord = request.getParameter("oldPassWord");
		String newPassWord = request.getParameter("newPassWord");
		String confirmNewPassWord = request.getParameter("confirmNewPassWord");
		
		String url="/account-detail.jsp";
		String error="";
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("Customer");
		customer c1 = null;
		if (obj!=null)
			c1 = (customer)obj;
		if(!oldPassWord.equals(c1.getPassWord()))
		{
			error="Mật khẩu hiện tại không chính xác!";
		}
		else
		{
			if(!newPassWord.equals(confirmNewPassWord))
				error="Mật khẩu nhập lại không chính xác!";
			else
			{
				c1.setPassWord(newPassWord);
				customerDAO cD = new customerDAO();
				if(cD.changePassWord(c1))
					error="Change password success.";
				else
					error="Thay đổi mật khẩu thất bại.";
			}
		}
		request.setAttribute("error", error);
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
