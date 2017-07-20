package dao.interfaces;

import java.util.List;

import entity.Lead;
import entity.Specialization;

public interface ILeadDao extends IDao<Lead> {
	
	/*
	 * get leads by specialization
	 */
	public List<Lead> getLeadsBySpecialization(Specialization specialization);
}
