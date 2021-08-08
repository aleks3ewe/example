package ru.rsreu.vkr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.vkr.datalayer.data.Users;
import ru.rsreu.vkr.resource.ConfigurationManager;

public class MainCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("userNow");
		if(user.getUserGroup() == 1) {
			page = ConfigurationManager.getProperty("path.page.main");
		}
		
		return page;
	}
}