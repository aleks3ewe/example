package ru.rsreu.vkr.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import ru.rsreu.vkr.datalayer.DAOFactory;
import ru.rsreu.vkr.datalayer.StorageDAO;
import ru.rsreu.vkr.datalayer.UsersDAO;


public class OracleDBDAOFactory extends DAOFactory {
	private static volatile OracleDBDAOFactory instance;
	private Connection connection;

	private OracleDBDAOFactory() {
	}

	public static OracleDBDAOFactory getInstance() throws ClassNotFoundException, SQLException {
		OracleDBDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDBDAOFactory.class) {
				instance = factory = new OracleDBDAOFactory();
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "SYSTEM";
		String password = "qqq";
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to oracle DB!");
	}
	
	@Override
	public StorageDAO getStorageDAO() {
		return new OracleStorageDAO(connection);
	}
	
	@Override
	public UsersDAO getUsersDAO() {
		return new OracleUsersDAO(connection);
	}
}
