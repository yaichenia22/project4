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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import entity.KindOfWork;
import entity.Tenant;
import manager.Config;
import service.KindsOfWorkService;
import service.request.RequestService;

public class CommandCreateRequest implements ICommand {

	private static final Logger logger = Logger.getLogger(CommandCreateRequest.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		Tenant user = (Tenant)session.getAttribute("user");
		
		KindsOfWorkService kindService = KindsOfWorkService.getInstance();
		String kindOfWorkName = (String)request.getParameter("kindOfWork");
		KindOfWork kindOfWork = null;
		if(kindOfWorkName != null){
			kindOfWork = kindService.getByName(kindOfWorkName);
		}
		
		String scopeOfWork = (String)request.getParameter("scopeOfWork");
		
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date desiredExDt = null;
		Timestamp desiredExecutionDate = null;
		try {
			desiredExDt = format.parse(request.getParameter("desiredExecutionDate"));
			desiredExecutionDate = new Timestamp(desiredExDt.getTime());
		} catch (ParseException e) {
			logger.error(e);
		}
		Timestamp applicationDate = new Timestamp(System.currentTimeMillis());
		
		String comment = (String)request.getParameter("comment");
		
		RequestService service = RequestService.getInstance();
		if (!scopeOfWork.isEmpty() && (kindOfWork != null) && (desiredExecutionDate != null)
				&& service.isDesiredExecutionDateCorrect(desiredExecutionDate, applicationDate)) {
			service.createRequest(user.getId(), kindOfWork.getId(), scopeOfWork, desiredExecutionDate, applicationDate, comment);
			
			request.setAttribute("createdNewRequest", true);
			return "/Controller?command=tenantRequest";
		}
		
		request.setAttribute("incorrectRequest", true);
		if(!scopeOfWork.isEmpty()){
			request.setAttribute("oldScopeOfWork", scopeOfWork);
		}
		if(kindOfWork != null){
			request.setAttribute("oldKindOfWork", kindOfWorkName);
		}
		if((desiredExecutionDate != null) && service.isDesiredExecutionDateCorrect(desiredExecutionDate, applicationDate)){
			request.setAttribute("olddesiredExecutionDate", format.format(desiredExecutionDate));
		}
		if(!comment.isEmpty()){
			request.setAttribute("oldComment", comment);
		}
		
		return Config.getInstance().getProperty(Config.CREATE_REQUEST);
	}
}
