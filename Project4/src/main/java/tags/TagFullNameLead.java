package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import entity.Lead;
import service.LeadService;

public class TagFullNameLead extends SimpleTagSupport {

	private static final Logger logger = Logger.getLogger(TagFullNameLead.class);
	private Long leadId;
	
	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}
	
	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		Lead lead = LeadService.getInstance().getById(leadId);
		
		try {
		out.println(lead.getFullName());
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
