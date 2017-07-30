package commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import entity.TeamMember;
import entity.WorkTeam;
import entity.WorkingPlan;
import service.TeamMemberService;
import service.WorkTeamService;
import service.WorkingPlanService;
import service.request.RequestService;

public class CommandDeleteWorkplan implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext servletContext = request.getSession().getServletContext();
		if(!(boolean)servletContext.getAttribute("isPlanFreeForDelete" + request.getParameter("workplanIdForRemoving"))){
			request.setAttribute("deletingAccessDenied", true);
			request.setAttribute("scope", request.getParameter("scope"));
			return "/Controller?command=workplanManager";
		}
		servletContext.setAttribute("isPlanFreeForDelete" + request.getParameter("workplanIdForRemoving"), false);
		RequestService requestService = RequestService.getInstance();
		WorkingPlanService workingPlanService = WorkingPlanService.getInstance();
		WorkTeamService workTeamService = WorkTeamService.getInstance();
		TeamMemberService teamMemberService = TeamMemberService.getInstance();
		
		Long workplanIdForRemoving = new Long(request.getParameter("workplanIdForRemoving"));
		WorkingPlan workingPlan = workingPlanService.getById(workplanIdForRemoving);
		Request requestForRemoving = requestService.getById(workingPlan.getRequestId());
		WorkTeam workTeam = workTeamService.getById(workingPlan.getWorkTeamId());
		List<TeamMember> teamMembers = teamMemberService.getAllByWorkTeam(workTeam);
			
		for(TeamMember member: teamMembers) {
			teamMemberService.remove(member);
		}
		workingPlanService.remove(workingPlan);
		workTeamService.remove(workTeam);
		RequestService.getInstance().remove(requestForRemoving);
		
		request.setAttribute("scope", request.getParameter("scope"));
		return "/Controller?command=workplanManager";
	}
}