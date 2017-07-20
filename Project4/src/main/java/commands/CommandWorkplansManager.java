package commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.WorkingPlan;
import manager.Config;
import service.KindsOfWorkService;
import service.WorkingPlanService;

public class CommandWorkplansManager implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		WorkingPlanService service = WorkingPlanService.getInstance();
		
		List<WorkingPlan> workingPlans = null;
		
		String scope = request.getParameter("scope");
		switch(scope){
		case "all": workingPlans = service.getAll(); break;
		case "done": workingPlans = service.getDoneWorkingPlans(); break;
		case "inProcess": workingPlans = service.getWorkingPlansInProcess(); break;
		default: workingPlans = service.getPlansByKindOfWork(KindsOfWorkService.getInstance().getByName(scope));
		}
		request.setAttribute("workingPlans", workingPlans);
		
		return Config.getInstance().getProperty(Config.WORKPLANS_MANAGER);
	}
}
