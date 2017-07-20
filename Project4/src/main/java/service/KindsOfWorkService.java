package service;

import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.IKindOfWorkDao;
import entity.KindOfWork;

public class KindsOfWorkService {

	private static KindsOfWorkService kindsOfWorkService = null;
	private static IKindOfWorkDao kindOfWorkDao = null;
	
	private KindsOfWorkService() {
		kindOfWorkDao = DaoDBFactory.getInstance().getKindOfWorkDao();
	}
	
	public static KindsOfWorkService getInstance() {
		if (kindsOfWorkService == null) {
			kindsOfWorkService = new KindsOfWorkService();
		}
		return kindsOfWorkService;
	}
	
	public List<KindOfWork> getAll() {
		return kindOfWorkDao.getAll();
	}
	
	public KindOfWork getByName(String name) {
		return kindOfWorkDao.getByName(name);
	}
	
	public KindOfWork getById(Long id) {
		return kindOfWorkDao.getById(id);
	}
}
