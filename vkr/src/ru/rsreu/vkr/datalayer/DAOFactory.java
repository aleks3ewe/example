package ru.rsreu.vkr.datalayer;

import ru.rsreu.vkr.datalayer.DAOFactory;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract StorageDAO getStorageDAO();

	public abstract UsersDAO getUsersDAO();
}