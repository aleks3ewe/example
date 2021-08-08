package ru.rsreu.vkr.command.actions;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ru.rsreu.vkr.datalayer.DAOFactory;
import ru.rsreu.vkr.datalayer.DBType;
import ru.rsreu.vkr.datalayer.StorageDAO;
import ru.rsreu.vkr.datalayer.UsersDAO;
import ru.rsreu.vkr.datalayer.data.Storage;
import ru.rsreu.vkr.datalayer.data.Users;

public class DownloadDB {
	public static void download(HttpServletRequest request) {
		ServletContext sc = request.getServletContext();
		
		DAOFactory daoFactory = DAOFactory.getInstance(DBType.ORACLE);
		
		StorageDAO storageDAO = daoFactory.getStorageDAO();
		UsersDAO usersDAO = daoFactory.getUsersDAO();
		
		ArrayList<Storage> storage = storageDAO.getStorage();
		ArrayList<Users> users = usersDAO.getUsers();
		
		sc.setAttribute("storage", storage);
		sc.setAttribute("users", users);
	}
}