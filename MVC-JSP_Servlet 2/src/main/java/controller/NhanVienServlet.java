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
import model.bo.LoginBO;
import model.bo.NhanVienBO;
import model.bo.PhongBanBO;


@WebServlet("/NhanVienServlet")
public class NhanVienServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		doPost(request, reponse);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		String destination = null;
		String action = request.getParameter("action");
		NhanVienBO nvBO = new NhanVienBO();
		if (action.equals("them"))
		{
			try {
					String idnv = request.getParameter("idnv");
					String hoten = request.getParameter("hoten");
					String diachi = request.getParameter("diachi");
					String idpb = request.getParameter("idpb");
					if (nvBO.checkIDNV(idnv)==false)
					{
						nhanvien nv = new nhanvien();
						nv.setIDNV(idnv);
						nv.setHoTen(hoten);
						nv.setDiaChi(diachi);
						nv.setIDPB(idpb);
						nvBO.addNV(nv);
						ArrayList<nhanvien> NVArray = new ArrayList<nhanvien>();
						NVArray = nvBO.getListNV();
						destination = "/listNV.jsp";
						request.setAttribute("NVArray", NVArray);
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, reponse);
					}
					else
					{
						destination = "/AddNVForm.jsp";
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, reponse);
					}
			} //catch (SQLException | ServletException | IOException | ClassNotFoundException e) 
			catch (SQLException | ServletException | IOException | ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (action.equals("xoa"))
		{
			ArrayList<nhanvien> NVArray = new ArrayList<nhanvien>();
			try {
				NVArray = nvBO.getListNV();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destination = "/DeleteNVForm.jsp";
			request.setAttribute("NVArray", NVArray);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, reponse);
		}
		else if (action.equals("xacnhanxoa"))
		{
			try
			{
				String idnv = request.getParameter("idnv");
				nvBO.deleteNV(idnv);
				ArrayList<nhanvien> NVArray = new ArrayList<nhanvien>();
				NVArray = nvBO.getListNV();
				destination = "/DeleteNVForm.jsp";
				request.setAttribute("NVArray", NVArray);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, reponse);
			}
			catch(SQLException | ServletException | IOException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		else if (action.equals("xoatatca"))
		{
			ArrayList<nhanvien> NVArray = new ArrayList<nhanvien>();
			try {
				NVArray = nvBO.getListNV();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destination = "/DeleteAllNVForm.jsp";
			request.setAttribute("NVArray", NVArray);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, reponse);
		}
		else if (action.equals("xacnhanxoatatca"))
		{
			try
			{
				//String idnv = request.getParameter("idnv");
				//nvBO.deleteNV(idnv);
				ArrayList<nhanvien> NVArray = new ArrayList<nhanvien>();
				String[] list = request.getParameterValues("list[]");
				for (int i=0; i<list.length;i++)
				{
					nvBO.deleteNV(list[i]);
				}
				NVArray = nvBO.getListNV();
				destination = "/DeleteAllNVForm.jsp";
				request.setAttribute("NVArray", NVArray);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, reponse);
			}
			catch(SQLException | ServletException | IOException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		else if (action.equals("timkiem"))
		{
			String type = request.getParameter("luachon");
			String info = request.getParameter("thongtin");
			try
			{
				ArrayList<nhanvien> NVArray = new ArrayList<nhanvien>();
				NVArray = nvBO.searchNV(type, info);
				destination = "/listNV.jsp";
				request.setAttribute("NVArray", NVArray);
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
