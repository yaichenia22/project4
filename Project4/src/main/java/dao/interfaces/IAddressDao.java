package dao.interfaces;

import java.util.List;

import entity.Address;
import entity.Tenant;

public interface IAddressDao extends IDao<Address> {

	/*
	 * get free flats
	 */
	public List<Address> getFreeAdresses();
	
	/*
	 * get adress be tenant
	 */
	public Address getAdressByTenant(Tenant tenant);
}
