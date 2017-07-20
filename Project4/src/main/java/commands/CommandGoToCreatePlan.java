package commands;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.KindOfWork;
import entity.Request;
import entity.Specialization;
import manager.Config;
import service.EmployeeService;
import service.KindsOfWorkService;
import service.LeadService;
import service.SpecializationService;
import service.request.RequestService;

public class CommandGoToCreatePlan implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext servletContext = request.getSession().getServletContext();
		if(!(boolean)servletContext.getAttribute("isRequestFreeForProcess" + request.getParameter("requestIdForProcess"))){
			request.setAttribute("processAccessDenied", true);
			request.setAttribute("scope", request.getParameter("scope"));
			return "/Controller?command=requestManager";
		}
		servletContext.setAttribute("isRequestFreeForProcess" + request.getParameter("requestIdForProcess"), false);
		Request requestForProcess = RequestService.getInstance().getById(new Long(request.getParameter("requestIdForProcess")));
		KindOfWork requestKind = KindsOfWorkService.getInstance().getById(requestForProcess.getKindOfWorkId());
		Specialization requestSpecialization = SpecializationService.getInstance().getByName(requestKind.getName());
		request.setAttribute("leadsForPlan", LeadService.getInstance().getBySpecialization(requestSpecialization));
		request.setAttribute("employeeForPlan", EmployeeService.getInstance().getBySpecialization(requestSpecialization));
		request.setAttribute("scope", request.getParameter("scope"));
		
		return Config.getInstance().getProperty(Config.CREATE_WORKING_PLAN);
	}
}