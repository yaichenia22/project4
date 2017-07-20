package dao.interfaces;

import entity.Dispatcher;

public interface IDispatcherDao extends IDao<Dispatcher> {

	/*
	 * this method returns dispatcher entity by login, which it has taken as parameter
	 */
	public Dispatcher getDispatcherByLogin(String login);
	
}
