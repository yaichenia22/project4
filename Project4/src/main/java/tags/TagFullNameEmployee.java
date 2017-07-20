package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import entity.Employee;
import service.EmployeeService;

public class TagFullNameEmployee extends SimpleTagSupport {

	private static final Logger logger = Logger.getLogger(TagFullNameEmployee.class);
	private Long employeeId;
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		Employee employee = EmployeeService.getInstance().getById(employeeId);
		
		try {
		out.println(employee.getFullName());
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
