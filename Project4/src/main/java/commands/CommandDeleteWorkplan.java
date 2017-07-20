package commands;

import java.io.IOException;
import java.util.List;

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
		
		RequestService requestService = RequestService.getInstance();
		WorkingPlanService workingPlanService = WorkingPlanService.getInstance();
		WorkTeamService workTeamService = WorkTeamService.getInstance();
		TeamMemberService teamMemberService = TeamMemberService.getInstance();
		
		Long workplanIdForRemoving = new Long(request.getParameter("workplanIdForRemoving"));
		WorkingPlan workingPlan = workingPlanService.getById(workplanIdForRemoving);
		Request requestForRemoving = requestService.getById(workingPlan.getRequestId());
		WorkTeam workTeam = workTeamService.getById(workingPlan.getWorkTeamId());
		List<TeamMember> teamMembers = teamMemberService.getAllByWorkTeam(workTeam);
		
		RequestService.getInstance().remove(requestForRemoving);
		for(TeamMember member: teamMembers) {
			teamMemberService.remove(member);
		}
		workTeamService.remove(workTeam);
		workingPlanService.remove(workingPlan);
		
		request.setAttribute("scope", request.getParameter("scope"));
		return "/Controller?command=workplanManager";
	}
}