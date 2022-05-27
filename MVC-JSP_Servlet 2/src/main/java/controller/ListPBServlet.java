package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.phongban;
import model.bo.LoginBO;
import model.bo.PhongBanBO;


@WebServlet("/ListPBServlet")
public class ListPBServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		doPost(request, reponse);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		String destination = null;
		String login = request.getParameter("login");
		LoginBO checkLoginBO = new LoginBO();
		PhongBanBO pbBO = new PhongBanBO();
		ArrayList<phongban> PBArray = null;
		if (login.equals("admin"))
		{
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			try {
				if (checkLoginBO.isExistUser(userName, passWord))
				{
					PBArray = pbBO.getListPhongBan();
					destination = "/admin_index.jsp";
					request.setAttribute("PBArray", PBArray);
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, reponse);
				}
				else
				{
					destination = "/login.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, reponse);
				}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (login.equals("guest"))
		{
			try
			{
				PBArray = pbBO.getListPhongBan();
				destination = "/guest_index.jsp";
				request.setAttribute("PBArray", PBArray);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, reponse);
			}
			catch(SQLException | ServletException | IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
