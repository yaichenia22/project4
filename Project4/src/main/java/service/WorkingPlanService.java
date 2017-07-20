package service;

import java.sql.Timestamp;
import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.IWorkingPlanDao;
import entity.KindOfWork;
import entity.Request;
import entity.WorkingPlan;

public class WorkingPlanService {

	private static WorkingPlanService workingPlanService = null;
	private static IWorkingPlanDao workingPlanDao = null;
	
	private WorkingPlanService() {
		workingPlanDao = DaoDBFactory.getInstance().getWorkingPlanDao();
	}
	
	public static WorkingPlanService getInstance() {
		if (workingPlanService == null) {
			workingPlanService = new WorkingPlanService();
		}
		return workingPlanService;
	}
	
	public List<WorkingPlan> getAll() {
		return workingPlanDao.getAll();
	}
	
	public List<WorkingPlan> getDoneWorkingPlans() {
		return workingPlanDao.getDoneWorkingPlans();
	}
	
	public List<WorkingPlan> getWorkingPlansInProcess() {
		return workingPlanDao.getWorkingPlansInProcess();
	}
	
	public List<WorkingPlan> getPlansByKindOfWork(KindOfWork kindOfWork) {
		return workingPlanDao.getPlansByKindOfWork(kindOfWork);
	}
	
	public void createPlan(Long workTeamId, Long dispatcherId, Long requestId,Timestamp estimatedExecutionDate,
			Timestamp estimatedStartDate, String comment) {	
		WorkingPlan plan = new WorkingPlan(workTeamId, dispatcherId, requestId,
				estimatedExecutionDate, estimatedStartDate, comment);
		workingPlanDao.add(plan);
	}
	
	public WorkingPlan getById(Long id) {
		return workingPlanDao.getById(id);
	}
	
	public void remove(WorkingPlan workingPlan) {
		workingPlanDao.remove(workingPlan);
	}
	
	public WorkingPlan getByRequest(Request request) {
		return workingPlanDao.getPlanByRequest(request);
	}
}
