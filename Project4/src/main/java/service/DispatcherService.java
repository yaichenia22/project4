package service;

import dao.impl.DaoDBFactory;
import dao.interfaces.IDispatcherDao;
import entity.Dispatcher;

public class DispatcherService {

	private static DispatcherService dispatcherService = null;
	private IDispatcherDao dispatcherDao = null;
	
	private DispatcherService() {
		dispatcherDao = DaoDBFactory.getInstance().getDispathcerDao();
	}
	
	public static DispatcherService getInstance() {
		if (dispatcherService == null) {
			dispatcherService = new DispatcherService();
		}
		return dispatcherService;
	}
	
	public boolean find(String login, String password) {
		Dispatcher dispatcher = dispatcherDao.getDispatcherByLogin(login);
		
		if (dispatcher.getId() != null) {
			if (dispatcher.getPassword().equals(password))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public Dispatcher getByLogin(String login) {
		return dispatcherDao.getDispatcherByLogin(login);
	}
}
