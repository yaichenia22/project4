package commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import manager.Config;
import service.AddressService;
import service.TenantService;
import service.request.RequestService;

public class CommandRequestForDispatcher implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long requestId = new Long(request.getParameter("requestForDisp"));
		Request requestForDispatcher = RequestService.getInstance().getById(requestId);
		
		request.setAttribute("requestForDispatcher", requestForDispatcher);
		request.setAttribute("requestId", requestId.longValue());
		request.setAttribute("tenantName", TenantService.getInstance()
				.getById(requestForDispatcher.getTenantId()).getFullName());
		request.setAttribute("fullAddress", AddressService.getInstance()
				.getComplexName(AddressService.getInstance().getById(TenantService
						.getInstance().getById(requestForDispatcher.getTenantId()).getAddressId())));
		request.setAttribute("requestForDispatcher", requestForDispatcher);
		
		return Config.getInstance().getProperty(Config.REQUEST_FOR_DISPATCHER);
	}
}
