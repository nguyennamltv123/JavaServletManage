package model.bo;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.nhanvien;
import model.dao.NhanVienDAO;
public class NhanVienBO {
	NhanVienDAO nvDAO = new NhanVienDAO();
	public boolean addNV(nhanvien nv) throws ClassNotFoundException, SQLException
	{
		return nvDAO.addNV(nv);
	}
	public boolean deleteNV(String idnv) throws ClassNotFoundException, SQLException
	{
		return nvDAO.deleteNV(idnv);
	}
	public ArrayList<nhanvien> searchNV(String type, String text) throws SQLException
	{
		return nvDAO.searchNV(type, text);
	}
	public boolean checkIDNV(String idnv) throws SQLException
	{
		return nvDAO.checkIDNV(idnv);
	}
	public ArrayList<nhanvien> getListNV() throws SQLException
	{
		return nvDAO.getListNV();
	}
	public ArrayList<nhanvien> getListNVTheoPB(String idpb) throws SQLException
	{
		return nvDAO.getListNVTheoPB(idpb);
	}
}
