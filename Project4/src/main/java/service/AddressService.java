package service;

import dao.impl.DaoDBFactory;
import dao.interfaces.IAddressDao;
import entity.Address;
import entity.Tenant;

public class AddressService {

	private static AddressService addressService = null;
	private IAddressDao addressDao = null;
	
	private AddressService() {
		addressDao = DaoDBFactory.getInstance().getAddressDao();
	}
	
	public static AddressService getInstance() {
		if (addressService == null) {
			addressService = new AddressService();
		}
		return addressService;
	}
	
	public Address getById(Long id) {
		return addressDao.getById(id);
	}
	
	public Address getByTenant(Tenant tenant) {
		return addressDao.getAdressByTenant(tenant);
	}
	
	public String getComplexName(Address address){
		return (address.getStreet() + " street, house " + address.getHouseNumber() + ", flat " + address.getFlatNumber());
	}
}
