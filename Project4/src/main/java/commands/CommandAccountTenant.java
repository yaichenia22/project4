package commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Tenant;
import manager.Config;
import service.AddressService;

public class CommandAccountTenant implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Tenant user = (Tenant)session.getAttribute("user");
		session.setAttribute("tenantAddress", AddressService.getInstance().getComplexName(AddressService.getInstance().getByTenant(user)));
		return Config.getInstance().getProperty(Config.TENANT_ACCOUNT);
	}
}
