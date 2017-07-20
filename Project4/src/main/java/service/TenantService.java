package service;

import dao.impl.DaoDBFactory;
import dao.interfaces.ITenantDao;
import entity.Tenant;

public class TenantService {
	
	private static TenantService tenantService = null;
	private ITenantDao tenantDao = null;
	
	private TenantService() {
		tenantDao = DaoDBFactory.getInstance().getTenantDao();
	}
	
	public static TenantService getInstance() {
		if (tenantService == null) {
			tenantService = new TenantService();
		}
		return tenantService;
	}
	
	public boolean find(String login, String password) {
		Tenant tenant = tenantDao.getTenantByLogin(login);
		
		if (tenant.getId() != null) {
			if (tenant.getPassword().equals(password))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public Tenant getByLogin(String login) {
		return tenantDao.getTenantByLogin(login);
	}
	
	public Tenant getById(Long id){
		return tenantDao.getById(id);
	}
}
