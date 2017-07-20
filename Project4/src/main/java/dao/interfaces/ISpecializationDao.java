package dao.interfaces;

import entity.Specialization;

public interface ISpecializationDao extends IDao<Specialization> {
	
	/*
	 * get specialization by its name
	 */
	public Specialization getByName(String name);
	
}
