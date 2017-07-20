package dao.interfaces;

import entity.KindOfWork;

public interface IKindOfWorkDao extends IDao<KindOfWork> {
	
	/*
	 * get kind of work by name
	 */
	public KindOfWork getByName(String name);
}
