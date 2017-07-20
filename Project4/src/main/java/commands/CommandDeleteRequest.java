package commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import service.request.RequestService;

public class CommandDeleteRequest implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long requestIdForRemoving = new Long(request.getParameter("requestIdForRemoving"));
		Request requestForRemoving = RequestService.getInstance().getById(requestIdForRemoving);
		RequestService.getInstance().remove(requestForRemoving);
		request.setAttribute("deletedRequestId", requestIdForRemoving);
		request.setAttribute("scope", request.getAttribute("scope"));
		
		return "/Controller?command=requestManager";
	}
}
