package service;

import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.ILeadDao;
import entity.Lead;
import entity.Specialization;

public class LeadService {

	private static LeadService leadService = null;
	private static ILeadDao leadDao = null;
	
	private LeadService() {
		leadDao = DaoDBFactory.getInstance().getLeadDao();
	}
	
	public static LeadService getInstance() {
		if (leadService == null) {
			leadService = new LeadService();
		}
		return leadService;
	}
	
	public List<Lead> getAll() {
		return leadDao.getAll();
	}
	
	public List<Lead> getBySpecialization(Specialization specialization) {
		return leadDao.getLeadsBySpecialization(specialization);
	}
	
	public Lead getById(Long id) {
		return leadDao.getById(id);
	}
}
