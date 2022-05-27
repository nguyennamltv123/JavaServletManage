package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.phongban;

public class PhongBanDAO {
	static String url = "jdbc:mysql://localhost:3306/dulieu";
	static String user = "root";
	static String pass = "18072001";
	
	public boolean updatePhongBan(phongban pb) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		String query = "update dulieu.phongban set tenpb = '" + pb.getTenPB() + "', mota = '" + pb.getMoTa() + "' where idpb = '" + pb.getIDPB() + "'";
		stmt.executeUpdate(query);
		return true;
	}
	
	public phongban getPBByIDPB(String idpb) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		String query = "select * from dulieu.phongban where idpb = '" + idpb + "'";
		ResultSet rs = stmt.executeQuery(query);
		phongban pb = new phongban();
		while(rs.next())
		{
			pb.setIDPB(rs.getString("idpb"));
			pb.setTenPB(rs.getString("tenpb"));
			pb.setMota(rs.getString("mota"));
		}
		return pb;
	}
	
	public ArrayList<phongban> getListPB() throws SQLException
	{
		ArrayList<phongban> result = new ArrayList<phongban>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select * from dulieu.phongban";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				phongban w = new phongban();
				String idpb = rs.getString("idpb");
				String tenpb = rs.getString("tenpb");
				String mota = rs.getString("mota");
				w.setIDPB(idpb);
				w.setTenPB(tenpb);
				w.setMota(mota);
				result.add(w);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
