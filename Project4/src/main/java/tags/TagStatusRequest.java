package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;

import org.apache.log4j.Logger;

import entity.Request;
import service.request.RequestService;
import service.request.Status;

public class TagStatusRequest extends SimpleTagSupport {

	private static final Logger logger = Logger.getLogger(TagStatusRequest.class);
	private Request request;

	public void setRequest(Request request) {
		this.request = request;
	}

	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		Status status = RequestService.getInstance().getStatus(request);
		
		PageContext pageContext = (PageContext)getJspContext();
		HttpServletRequest httpRequest = (HttpServletRequest) pageContext.getRequest();
		httpRequest.setAttribute("requestStatusName", status.getName());
		try {
		out.println(status.getName());
		} catch (IOException e) {
			logger.error(e);
		}
	}
}