package ru.rsreu.vkr.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.vkr.command.ActionCommand;
import ru.rsreu.vkr.command.factory.ActionFactory;
import ru.rsreu.vkr.resource.ConfigurationManager;
import ru.rsreu.vkr.resource.MessageManager;

@WebServlet("/main")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;

		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		page = command.execute(request);

		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

			dispatcher.forward(request, response);
		} else {

			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}