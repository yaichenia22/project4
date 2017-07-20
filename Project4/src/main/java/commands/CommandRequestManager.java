package commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import manager.Config;
import service.request.RequestService;

public class CommandRequestManager implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestService service = RequestService.getInstance();
		
		List<Request> requests = null;
		int allReqCount = RequestService.getInstance().getAll().size();
		int doneReqCount = RequestService.getInstance().getDoneRequests().size();
		int unconsReqCount = RequestService.getInstance().getUnconsideredRequests().size();
		int inProgReqCount = allReqCount - doneReqCount - unconsReqCount;
		
		request.setAttribute("allReqCount", allReqCount);
		request.setAttribute("doneReqCount", doneReqCount);
		request.setAttribute("unconsReqCount", unconsReqCount);
		request.setAttribute("inProgReqCount", inProgReqCount);

		String scope = request.getParameter("scope");
		switch(scope){
		case "done": requests = service.getDoneRequests(); break;
		case "unconsidered": requests = service.getUnconsideredRequests(); break;
		case "inProgress": requests = service.getRequestsInProgress(); break;
		default: requests = service.getAll();
		}

		request.setAttribute("requestsForManager", requests);
		
		return Config.getInstance().getProperty(Config.REQUEST_MANAGER);
	}
}