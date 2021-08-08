package ru.rsreu.vkr.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.googlecode.fannj.Fann;

import ru.rsreu.vkr.command.actions.DownloadDB;
import ru.rsreu.vkr.datalayer.DAOFactory;
import ru.rsreu.vkr.datalayer.DBType;
import ru.rsreu.vkr.datalayer.StorageDAO;
import ru.rsreu.vkr.datalayer.data.Users;
import ru.rsreu.vkr.fann.BunkruptTest;
import ru.rsreu.vkr.resource.ConfigurationManager;

public class CountCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		
		DAOFactory daoFactory = DAOFactory.getInstance(DBType.ORACLE);
		
		float x01 = Float.parseFloat(request.getParameter("x01"));
		float x02 = Float.parseFloat(request.getParameter("x02"));
		float x03 = Float.parseFloat(request.getParameter("x03"));
		float x04 = Float.parseFloat(request.getParameter("x04"));
		float x05 = Float.parseFloat(request.getParameter("x05"));
		
		Users user = (Users)session.getAttribute("userNow");
		
		float k1 = x05/x03;
		float k2 = 1 - ((x02+x03)/x01);
		float extra1 = x01/(x04+x05);
		float extra2 = (x01-x04)/x05;
		
		String path = sc.getRealPath("/WEB-INF/datafann/ann");
		
		Fann fann = new Fann(path);
		
		int result = BunkruptTest.count(fann, k1, k2, extra1, extra2);
		request.setAttribute("result", result);
		
		StorageDAO storageDAO = daoFactory.getStorageDAO();
		
		storageDAO.setStorage(user.getId(), k1, k2, extra1, extra2, result);
		
		DownloadDB.download(request);
		
		String page = ConfigurationManager.getProperty("path.page.main");
		return page;
	}
}