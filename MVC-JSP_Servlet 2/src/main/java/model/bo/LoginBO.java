package model.bo;

import java.sql.SQLException;

import model.dao.LoginDAO;

public class LoginBO {
	LoginDAO logDAO = new LoginDAO();
	public boolean isExistUser(String username, String password) throws SQLException
	{
		return logDAO.isExistUser(username, password);
	}
}
