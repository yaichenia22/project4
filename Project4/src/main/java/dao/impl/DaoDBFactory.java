package dao.impl;

import dao.interfaces.AbstractDaoFactory;
import dao.interfaces.IAddressDao;
import dao.interfaces.IDispatcherDao;
import dao.interfaces.IEmployeeDao;
import dao.interfaces.IKindOfWorkDao;
import dao.interfaces.ILeadDao;
import dao.interfaces.IRequestDao;
import dao.interfaces.ISpecializationDao;
import dao.interfaces.ITeamMemberDao;
import dao.interfaces.ITenantDao;
import dao.interfaces.IWorkTeamDao;
import dao.interfaces.IWorkingPlanDao;

public class DaoDBFactory implements AbstractDaoFactory {

	private static final DaoDBFactory DAO_DB_FACTORY = new DaoDBFactory();
	
	private DaoDBFactory() {
		
	}
	
	public static DaoDBFactory getInstance() {
		return DAO_DB_FACTORY;
	}
	
	@Override
	public IAddressDao getAddressDao() {
		return AddressDBDao.getInstance();
	}

	@Override
	public IDispatcherDao getDispathcerDao() {
		return DispatcherDBDao.getInstance();
	}

	@Override
	public IEmployeeDao getEmployeeDao() {
		return EmployeeDBDao.getInstance();
	}

	@Override
	public IKindOfWorkDao getKindOfWorkDao() {
		return KindOfWorkDBDao.getInstance();
	}

	@Override
	public ILeadDao getLeadDao() {
		return LeadDBDao.getInstance();
	}

	@Override
	public IRequestDao getRequestDao() {
		return RequestDBDao.getInstance();
	}

	@Override
	public ISpecializationDao getSpecializationDao() {
		return SpecializationDBDao.getInstance();
	}

	@Override
	public ITeamMemberDao getTeamMemberDao() {
		return TeamMemberDBDao.getInstance();
	}

	@Override
	public ITenantDao getTenantDao() {
		return TenantDBDao.getInstance();
	}

	@Override
	public IWorkingPlanDao getWorkingPlanDao() {
		return WorkingPlanDBDao.getInstance();
	}

	@Override
	public IWorkTeamDao getWorkTeamDao() {
		return WorkTeamDBDao.getInstance();
	}
}
