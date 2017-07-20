package service.request;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.impl.DaoDBFactory;
import dao.interfaces.IKindOfWorkDao;
import dao.interfaces.IRequestDao;
import entity.KindOfWork;
import entity.Request;
import entity.Tenant;

public class RequestService {

	private static RequestService requestService = null;
	private static IRequestDao requestDao = null;
	private static IKindOfWorkDao kindDao = null;

	protected RequestService() {
		requestDao = DaoDBFactory.getInstance().getRequestDao();
		kindDao = DaoDBFactory.getInstance().getKindOfWorkDao();
	}

	public static RequestService getInstance() {
		if (requestService == null) {
			requestService = new RequestService();
		}
		return requestService;
	}

	public Map<Long, String> getKindsOfWork() {
		List<KindOfWork> kindsOdWork = kindDao.getAll();
		Map<Long, String> result = new HashMap<>();
		for (KindOfWork kind : kindsOdWork) {
			Long kindID = kind.getId();
			String kindName = kind.getName();
			result.put(kindID, kindName);
		}
		return result;
	}

	public List<Request> getAll() {
		return requestDao.getAll();
	}

	public List<Request> getByTenant(Tenant tenant) {
		return requestDao.getAllRequestsFromTenant(tenant);
	}

	public List<Request> getConsideredRequestsOfTenant(Tenant tenant) {
		return requestDao.getConsideredRequestsOfTenant(tenant);
	}

	public List<Request> getUnconsideredRequests() {
		return requestDao.getAllUnconsideredRequests();
	}

	public List<Request> getDoneRequests() {
		return requestDao.getDoneRequests();
	}
	
	public List<Request> getRequestsInProgress() {
		return requestDao.getAllRequestsInProgress();
	}

	public void createRequest(Long tenantId, Long kindOfWork, String scopeOfWork, Timestamp desiredExecutionDate,
			Timestamp applicationDate, String comment) {

		Request sourceRequest = new Request(tenantId, kindOfWork, scopeOfWork, desiredExecutionDate, applicationDate,
				comment);
		requestDao.add(sourceRequest);
	}
	
	public boolean isDesiredExecutionDateCorrect (Timestamp desiredExecutionDate, Timestamp applicationDate){
		return desiredExecutionDate.after(applicationDate);
	}
	
	public Status getStatus(Request request) {
		
		List<Request> unconsideredRequests = getUnconsideredRequests();
		List<Request> doneRequests = getDoneRequests();
		
		if (unconsideredRequests.contains(request)) {
			return Status.UNCONSIDERED;
		}
		if (doneRequests.contains(request)) {
			return Status.DONE;
		}
		return Status.IN_PROCESS;
	}
	
	public Request getById(Long id) {
		return requestDao.getById(id);
	}
	
	public void remove(Request request) {
		requestDao.remove(request);
	}
}