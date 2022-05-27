package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	static String url = "jdbc:mysql://localhost:3306/dulieu";
	static String user = "root";
	static String pass = "18072001";
	public boolean isExistUser(String username, String password) throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select count(*) from dulieu.admin where username = '" + username + "' and password = '" + password + "'";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			if (rs.getInt(1)==1) return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
