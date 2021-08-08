package ru.rsreu.vkr.oracledb;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rsreu.vkr.datalayer.data.Storage;
import ru.rsreu.vkr.datalayer.data.Users;

public class ResultSetParser {
	private ResultSetParser() {

	}

	public static Storage parseUserGroups(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		int owner = resultSet.getInt("owner");
		float x1 = resultSet.getFloat("x1");
		float x2 = resultSet.getFloat("x2");
		float x3 = resultSet.getFloat("x3");
		float x4 = resultSet.getFloat("x4");
		int bunkrupt = resultSet.getInt("bunkrupt");
		return new Storage(id, owner, x1, x2, x3, x4, bunkrupt);
	}

	public static Users parseUsers(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String login = resultSet.getString("login");
		String password = resultSet.getString("password");
		String email = resultSet.getString("email");
		int userGroup = resultSet.getInt("user_group");
		int isAuthorized = resultSet.getInt("is_authorized");
		int isBlocked = resultSet.getInt("is_blocked");
		return new Users(id, login, password, email, userGroup, isAuthorized, isBlocked);
	}
}
