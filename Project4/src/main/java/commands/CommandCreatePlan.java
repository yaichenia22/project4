package commands;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import entity.Dispatcher;
import entity.Request;
import entity.TeamMember;
import manager.Config;
import service.TeamMemberService;
import service.WorkTeamService;
import service.WorkingPlanService;
import service.request.RequestService;
import service.request.Status;

public class CommandCreatePlan implements ICommand {

	private static final Logger logger = Logger.getLogger(CommandCreatePlan.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long requestId = new Long (request.getParameter("requestIdForProcess"));
		Request requestForProcess = RequestService.getInstance().getById(requestId);
		if(!RequestService.getInstance().getStatus(requestForProcess).equals(Status.UNCONSIDERED)) {
			request.setAttribute("processAccessDenied", true);
			request.setAttribute("scope", (String)request.getAttribute("scope"));
			return "/Controller?command=requestManager";
		}
		Dispatcher dispatcher = (Dispatcher)request.getSession().getAttribute("user");
		
		Long workTeamId = WorkTeamService.getInstance().getCorrectId();
		Long leadId = new Long(request.getParameter("leadForPlan"));
		String name = request.getParameter("workteamName");
		if((workTeamId != null) && (leadId != null) && (name != null)) {
			WorkTeamService.getInstance().createTeam(workTeamId, leadId, name);
		}
		
		for(int i = 1; i <= 5; i++) {
			String attributeName = "member" + i;
			String attributeValue = request.getParameter(attributeName);
			if((workTeamId != null) && (attributeValue != null)) {
				TeamMemberService.getInstance().add(new TeamMember(workTeamId, new Long(attributeValue)));
			}
		}
		
		requestId = new Long (request.getParameter("requestIdForProcess"));
		
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date date = null;
		Timestamp estimatedExecutionDate = null;
		Timestamp estimatedStartDate = null;
		try {
			date = format.parse(request.getParameter("estimatedExecutionDate"));
			estimatedExecutionDate = new Timestamp(date.getTime());
			date = format.parse(request.getParameter("estimatedStartDate"));
			estimatedStartDate = new Timestamp(date.getTime());
		} catch (ParseException e) {
			logger.error(e);
		}
		String comment = (String)request.getAttribute("comment");
		
		WorkingPlanService service = WorkingPlanService.getInstance();
		if ((workTeamId != null) && (dispatcher != null) && (requestId != null) && (estimatedExecutionDate != null) && (estimatedStartDate != null)) {
			service.createPlan(workTeamId, dispatcher.getId(), requestId, estimatedExecutionDate, estimatedStartDate, comment);
			request.setAttribute("scope", (String)request.getAttribute("scope"));
			return "/Controller?command=requestManager";
		}
		
		request.setAttribute("incorrectPlan", true);
		
		return Config.getInstance().getProperty(Config.CREATE_WORKING_PLAN);
	}
}
