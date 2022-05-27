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


@WebServlet("/PhongBanServlet")
public class PhongBanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		doPost(request, reponse);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException
	{
		String destination = null;
		String action = request.getParameter("action");
		PhongBanBO pbBO = new PhongBanBO();
		if (action.equals("sua"))
		{
			ArrayList<phongban> PBArray = new ArrayList<phongban>();
			try {
				PBArray = pbBO.getListPhongBan();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("PBArray", PBArray);
			destination = "/UpdatePhongBan.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, reponse);
		}
		else if (action.equals("chondesua"))
		{
			String idpb = request.getParameter("idpb");
			try
			{
				phongban pb = pbBO.getPBByIDPB(idpb);
				request.setAttribute("phongban", pb);
				destination = "/UpdatePBForm.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, reponse);
			}
			catch(SQLException | ServletException | IOException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		else if (action.equals("xacnhansua"))
		{
			ArrayList<phongban> PBArray = new ArrayList<phongban>();
			phongban pb = new phongban();
			pb.setIDPB(request.getParameter("idpb"));
			pb.setTenPB(request.getParameter("tenpb"));
			pb.setMota(request.getParameter("mota"));
			try {
				pbBO.updatePhongBan(pb);
				PBArray = pbBO.getListPhongBan();
			} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("PBArray", PBArray);
			destination = "/UpdatePhongBan.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, reponse);
		}
	}
}
