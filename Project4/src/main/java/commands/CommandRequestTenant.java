package commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Request;
import entity.Tenant;
import manager.Config;
import service.request.RequestService;

public class CommandRequestTenant implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Tenant user = (Tenant)session.getAttribute("user");
		List<Request> requests = null;
		if(user != null) {
			requests = RequestService.getInstance().getByTenant(user);
		}
		session.setAttribute("requests", requests);
		return Config.getInstance().getProperty(Config.REQUESTS_FOR_TENANT);
	}
}
