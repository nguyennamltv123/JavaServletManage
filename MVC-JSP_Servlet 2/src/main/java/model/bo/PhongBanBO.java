package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.phongban;
import model.dao.PhongBanDAO;

public class PhongBanBO {
	PhongBanDAO pbDAO = new PhongBanDAO();
	public boolean updatePhongBan(phongban pb) throws SQLException, ClassNotFoundException
	{
		return pbDAO.updatePhongBan(pb);
	}
	public phongban getPBByIDPB(String idpb) throws ClassNotFoundException, SQLException
	{
		return pbDAO.getPBByIDPB(idpb);
	}
	public ArrayList<phongban> getListPhongBan() throws SQLException
	{
		return pbDAO.getListPB();
	}
}
