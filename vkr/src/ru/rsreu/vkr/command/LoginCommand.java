package ru.rsreu.vkr.command;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.vkr.datalayer.data.Users;
import ru.rsreu.vkr.resource.ConfigurationManager;

import ru.rsreu.vkr.command.actions.DownloadDB;

public class LoginCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		
		ServletContext sc = request.getServletContext();
		HttpSession session = request.getSession();
		
		String MyUsername = request.getParameter("login");
		String MyPassword = request.getParameter("password");
		String page = null;

		DownloadDB.download(request);

		
		ArrayList<Users> users = (ArrayList<Users>) sc.getAttribute("users");

		boolean failEnter = true;

		for (int i = 0; i < users.size(); i++) {
			String username = users.get(i).getLogin().toString();
			String password = users.get(i).getPassword().toString();

			if (MyUsername.equals(username) && MyPassword.equals(password) && users.get(i).getIsBlocked()!=1) {

				session.setAttribute("userNow", users.get(i));
				
				DownloadDB.download(request);
				
				if (users.get(i).getUserGroup() == 1) {
						page = ConfigurationManager.getProperty("path.page.main");
				}

				failEnter = false;
			}
		}
		
		if (failEnter) {
			session.setAttribute("errorLogin", true);
			page = ConfigurationManager.getProperty("path.page.index");
		}
		
		return page;
	}
}