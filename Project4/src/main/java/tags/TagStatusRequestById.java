package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import entity.Request;
import service.KindsOfWorkService;
import service.request.RequestService;
import service.request.Status;

public class TagStatusRequestById extends SimpleTagSupport {
	
	private static final Logger logger = Logger.getLogger(TagStatusRequestById.class);
	private Long requestId;

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext)getJspContext();
		Request request = RequestService.getInstance().getById(requestId);
		
		Status status = RequestService.getInstance().getStatus(RequestService.getInstance().getById(requestId));
		HttpServletRequest httpRequest = (HttpServletRequest) pageContext.getRequest();
		Long kindId = request.getKindOfWorkId();
		String planKindOfWork = KindsOfWorkService.getInstance().getById(kindId).getName();
		
		httpRequest.setAttribute("planKindOfWork", planKindOfWork);
		httpRequest.setAttribute("workplanStatus", status.getName());
		try {
		out.println(status.getName());
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
