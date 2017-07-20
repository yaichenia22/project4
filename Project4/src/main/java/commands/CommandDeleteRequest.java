package commands;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import service.request.RequestService;

public class CommandDeleteRequest implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext servletContext = request.getSession().getServletContext();
		if(!(boolean)servletContext.getAttribute("isRequestFreeForDelete" + request.getParameter("requestIdForRemoving"))){
			request.setAttribute("deletingAccessDenied", true);
			request.setAttribute("scope", request.getParameter("scope"));
			return "/Controller?command=requestManager";
		}
		servletContext.setAttribute("isRequestFreeForDelete" + request.getParameter("requestIdForRemoving"), false);
		Long requestIdForRemoving = new Long(request.getParameter("requestIdForRemoving"));
		Request requestForRemoving = RequestService.getInstance().getById(requestIdForRemoving);
		RequestService.getInstance().remove(requestForRemoving);
		request.setAttribute("deletedRequestId", requestIdForRemoving);
		request.setAttribute("scope", request.getAttribute("scope"));
		
		return "/Controller?command=requestManager";
	}
}
