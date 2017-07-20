package service;

import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.ISpecializationDao;
import entity.Specialization;

public class SpecializationService {
	private static SpecializationService specializationService = null;
	private static ISpecializationDao specializationDao = null;
	
	private SpecializationService() {
		specializationDao = DaoDBFactory.getInstance().getSpecializationDao();
	}
	
	public static SpecializationService getInstance() {
		if (specializationService == null) {
			specializationService = new SpecializationService();
		}
		return specializationService;
	}
	
	public List<Specialization> getAll() {
		return specializationDao.getAll();
	}
	
	public Specialization getByName(String name) {
		return specializationDao.getByName(name);
	}
}
