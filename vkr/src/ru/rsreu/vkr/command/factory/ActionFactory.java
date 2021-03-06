package ru.rsreu.vkr.command.factory;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.vkr.command.ActionCommand;
import ru.rsreu.vkr.command.EmptyCommand;
import ru.rsreu.vkr.command.client.CommandEnum;
import ru.rsreu.vkr.resource.MessageManager;

public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();

		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {

			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}