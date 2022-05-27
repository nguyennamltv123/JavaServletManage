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
import model.bean.nhanvien;
import model.bean.phongban;
import model.bo.NhanVienBO;


@WebServlet("/ListNVServlet")
public class ListNVServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		doPost(request, reponse);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		String destination = null;
		NhanVienBO nvBO = new NhanVienBO();
		ArrayList<nhanvien> NVArray = null;
		
		try {
				NVArray = nvBO.getListNV();
				destination = "/listNV.jsp";
				request.setAttribute("NVArray", NVArray);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, reponse);
				
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
