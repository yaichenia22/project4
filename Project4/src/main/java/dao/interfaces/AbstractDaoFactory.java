package dao.interfaces;

public interface AbstractDaoFactory {

	/*
	 * method that return instance of address DAO
	 */
	public IAddressDao getAddressDao();
	
	/*
	 * method that return instance of dispatcher DAO
	 */
	public IDispatcherDao getDispathcerDao();
	
	/*
	 * method that return instance of employee DAO
	 */
	public IEmployeeDao getEmployeeDao();
	
	/*
	 * method that return instance of kind of work DAO
	 */
	public IKindOfWorkDao getKindOfWorkDao();
	
	/*
	 * method that return instance of team lead DAO
	 */
	public ILeadDao getLeadDao();
	
	/*
	 * method that return instance of request DAO
	 */
	public IRequestDao getRequestDao();
	
	/*
	 * method that return instance of specialization DAO
	 */
	public ISpecializationDao getSpecializationDao();
	
	/*
	 * method that return instance of team member DAO
	 */
	public ITeamMemberDao getTeamMemberDao();
	
	/*
	 * method that return instance of tenant DAO
	 */
	public ITenantDao getTenantDao();
	
	/*
	 * method that return instance of working plan DAO
	 */
	public IWorkingPlanDao getWorkingPlanDao();
	
	/*
	 * method that return instance of working team DAO
	 */
	public IWorkTeamDao getWorkTeamDao();
}
