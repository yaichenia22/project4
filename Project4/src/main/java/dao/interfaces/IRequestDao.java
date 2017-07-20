package dao.interfaces;

import java.util.List;

import entity.KindOfWork;
import entity.Request;
import entity.Tenant;

public interface IRequestDao extends IDao<Request> {

	/*
	 * get all requests from one tenant
	 */
	public List<Request> getAllRequestsFromTenant(Tenant tenant);
	
	/*
	 * get all requests of one kind of work
	 */
	public List<Request> getAllRequestsOfKindWork(KindOfWork kindOfWork);
	
	/*
	 * get all request without consideration
	 */
	public List<Request> getAllUnconsideredRequests();
	
	/*
	 * get considered requests of tenant
	 */
	public List<Request> getConsideredRequestsOfTenant(Tenant tenant);
	
	/*
	 * get done requests
	 */
	public List<Request> getDoneRequests();
	
	/*
	 * get requests in progress
	 */
	public List<Request> getAllRequestsInProgress();
}
