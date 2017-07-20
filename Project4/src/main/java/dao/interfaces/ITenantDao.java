package dao.interfaces;

import entity.Address;
import entity.Tenant;

public interface ITenantDao extends IDao<Tenant> {
		
	/*
	 * get tenant by address
	 */
	public Tenant getTenantByAdress(Address address);

	/*
	 * get tenant by login
	 */
	public Tenant getTenantByLogin(String login);
}
