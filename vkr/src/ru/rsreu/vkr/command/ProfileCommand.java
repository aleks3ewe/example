package ru.rsreu.vkr.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.vkr.resource.ConfigurationManager;

public class ProfileCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		String login = request.getParameter(PARAM_NAME_LOGIN);
		request.setAttribute("user", login);

		page = ConfigurationManager.getProperty("path.page.profile");
		return page;
	}
}