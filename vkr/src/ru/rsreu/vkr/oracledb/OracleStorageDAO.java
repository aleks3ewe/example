package ru.rsreu.vkr.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.rsreu.vkr.datalayer.StorageDAO;
import ru.rsreu.vkr.datalayer.data.Storage;

public class OracleStorageDAO implements StorageDAO {
	private Connection connection;

	public OracleStorageDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public ArrayList<Storage> getStorage() {
		ArrayList<Storage> result = new ArrayList<Storage>();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM SYSTEM.\"storage\"");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Storage storage = new Storage(0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0);
				storage.setId(resultSet.getInt(1));
				storage.setOwner(resultSet.getInt(2));
				storage.setX1(resultSet.getFloat(3));
				storage.setX2(resultSet.getFloat(4));
				storage.setX3(resultSet.getFloat(5));
				storage.setX4(resultSet.getFloat(6));
				storage.setBunkrupt(resultSet.getInt(7));
				result.add(storage);
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
	
	@Override
	public int setStorage(int owner, float x1, float x2, float x3, float x4, int bunkrupt) {
		PreparedStatement statement = null;
        try{
        	statement = connection.prepareStatement("INSERT INTO SYSTEM.\"storage\" VALUES (seq_storage.nextval, ?, ?, ?, ?, ?, ?)");
        	statement.setInt(1, owner);   
        	statement.setFloat(2, x1);
        	statement.setFloat(3, x2);
        	statement.setFloat(4, x3);   
        	statement.setFloat(5, x4);
        	statement.setInt(6, bunkrupt);
        	return  statement.executeUpdate();  
        } catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}
}