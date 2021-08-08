package ru.rsreu.vkr.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.vkr.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");

		request.getSession().invalidate();
		return page;
	}
}