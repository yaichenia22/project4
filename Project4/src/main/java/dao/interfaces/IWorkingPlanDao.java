package dao.interfaces;

import java.sql.Timestamp;
import java.util.List;

import entity.KindOfWork;
import entity.Request;
import entity.WorkingPlan;

public interface IWorkingPlanDao extends IDao<WorkingPlan> {
	
	/*
	 * get plans by execute date
	 */
	public List<WorkingPlan> getPlansByExecuteDate(Timestamp executeDate);
	
	/*
	 * get plans by start date
	 */
	public List<WorkingPlan> getPlansByStartDate(Timestamp startDate);
	
	/*
	 * get plan by request
	 */
	public WorkingPlan getPlanByRequest(Request request);
	
	/*
	 * get done working plans
	 */
	public List<WorkingPlan> getDoneWorkingPlans();
	
	/*
	 * get working plans in process
	 */
	public List<WorkingPlan> getWorkingPlansInProcess();
	
	/*
	 * get plans by kind of work
	 */
	public List<WorkingPlan> getPlansByKindOfWork(KindOfWork kindOfWork);
}
