package ru.rsreu.vkr.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.rsreu.vkr.datalayer.UsersDAO;
import ru.rsreu.vkr.datalayer.data.Users;

public class OracleUsersDAO implements UsersDAO {
	private Connection connection;

	public OracleUsersDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public ArrayList<Users> getUsers() {
		ArrayList<Users> result = new ArrayList<Users>();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM SYSTEM.\"users\"");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Users users = new Users(0,"","","",0,0,0);
				users.setId(resultSet.getInt(1));
				users.setLogin(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setEmail(resultSet.getString(4));
				users.setUserGroup(resultSet.getInt(5));
				users.setIsAuthorized(resultSet.getInt(6));
				users.setIsBlocked(resultSet.getInt(7));
				result.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}