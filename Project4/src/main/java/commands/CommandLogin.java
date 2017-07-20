package commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Dispatcher;
import entity.Tenant;
import util.UserRole;
import manager.Config;
import manager.Message;
import service.DispatcherService;
import service.TenantService;
import service.request.RequestService;

public class CommandLogin implements ICommand {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String page = null;
		boolean isDispatcher = request.getParameter("dispatcher") != null;
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
		HttpSession session = request.getSession();
        if (isDispatcher) {
        	if (DispatcherService.getInstance().find(login, password)) {
        		session.setAttribute("userRole", UserRole.DISPATCHER);
        		session.setAttribute("user", DispatcherService.getInstance().getByLogin(login));
        		session.setAttribute("userFullName", ((Dispatcher)session.getAttribute("user")).getFullName());
        		session.setAttribute("kinds", RequestService.getInstance().getKindsOfWork());
            	page = Config.getInstance().getProperty(Config.DISPATCHER_MAIN);
        	}
        	else {
        		page = executeLoginError(request);
        	}
        } else {
        	if (TenantService.getInstance().find(login, password)) {
        		session.setAttribute("userRole", UserRole.TENANT);
        		session.setAttribute("user", TenantService.getInstance().getByLogin(login));
        		session.setAttribute("userFullName", ((Tenant)session.getAttribute("user")).getFullName());
        		session.setAttribute("kinds", RequestService.getInstance().getKindsOfWork());
            	page = Config.getInstance().getProperty(Config.TENANT_MAIN);
        	}
        	else{
        		page = executeLoginError(request);
        	}
        }
        return page;
	}
	
	private String executeLoginError(HttpServletRequest request) {
		request.setAttribute("loginError", Message.getInstance().getProperty(Message.LOGIN_ERROR));
		return Config.getInstance().getProperty(Config.LOGIN);
	}
}
