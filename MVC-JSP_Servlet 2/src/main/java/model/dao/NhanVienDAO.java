package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.nhanvien;

public class NhanVienDAO {
	static String url = "jdbc:mysql://localhost:3306/dulieu";
	static String user = "root";
	static String pass = "18072001";
	
	public boolean addNV(nhanvien nv) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		String query = "insert into dulieu.nhanvien values ('"+ nv.getIDNV() + "','"+ nv.getHoten() +"','"+ nv.getDiaChi() + "','"+ nv.getIDPB() +"')";
		stmt.executeUpdate(query);
		return true;
	}
	public boolean deleteNV(String idnv) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		String query = "delete from dulieu.nhanvien where idnv = '"+ idnv +"';";
		stmt.executeUpdate(query);
		return true;
	}
	public ArrayList<nhanvien> searchNV(String type, String text) throws SQLException
	{
		ArrayList<nhanvien> result = new ArrayList<nhanvien>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select * from dulieu.nhanvien where "+ type +" = '" + text + "'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				nhanvien w = new nhanvien();
				String idnv = rs.getString("idnv");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String idpb = rs.getString("idpb");
				w.setIDNV(idnv);
				w.setHoTen(hoten);
				w.setDiaChi(diachi);
				w.setIDPB(idpb);
				result.add(w);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean checkIDNV(String idnv) throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select count(*) from dulieu.nhanvien where idnv = '" + idnv + "'";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			if (rs.getInt(1)==1) return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public ArrayList<nhanvien> getListNVTheoPB(String IDPB) throws SQLException
	{
		ArrayList<nhanvien> result = new ArrayList<nhanvien>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select * from dulieu.nhanvien where idpb = '" + IDPB + "'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				nhanvien w = new nhanvien();
				String idnv = rs.getString("idnv");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String idpb = rs.getString("idpb");
				w.setIDNV(idnv);
				w.setHoTen(hoten);
				w.setDiaChi(diachi);
				w.setIDPB(idpb);
				result.add(w);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<nhanvien> getListNV() throws SQLException
	{
		ArrayList<nhanvien> result = new ArrayList<nhanvien>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select * from dulieu.nhanvien";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				nhanvien w = new nhanvien();
				String idnv = rs.getString("idnv");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String idpb = rs.getString("idpb");
				w.setIDNV(idnv);
				w.setHoTen(hoten);
				w.setDiaChi(diachi);
				w.setIDPB(idpb);
				result.add(w);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
