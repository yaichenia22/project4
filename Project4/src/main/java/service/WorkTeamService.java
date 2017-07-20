package service;

import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.IWorkTeamDao;
import entity.WorkTeam;

public class WorkTeamService {

	private static WorkTeamService workTeamService = null;
	private static IWorkTeamDao workTeamDao = null;
	
	private WorkTeamService() {
		workTeamDao = DaoDBFactory.getInstance().getWorkTeamDao();
	}
	
	public static WorkTeamService getInstance() {
		if (workTeamService == null) {
			workTeamService = new WorkTeamService();
		}
		return workTeamService;
	}
	
	public List<WorkTeam> getAll() {
		return workTeamDao.getAll();
	}
	
	public Long getCorrectId() {
		List<WorkTeam> workTeams = getAll();
		Long result = 0l;
		for(WorkTeam team : workTeams) {
			if(result < team.getId()) {
				result = team.getId();
			}
		}
		return result + 1l;
	}
	
	public void createTeam(Long id, Long leadId, String name) {
		workTeamDao.add(new WorkTeam(id, leadId, name));
	}
	
	public WorkTeam getById(Long id) {
		return workTeamDao.getById(id);
	}
	
	public void remove(WorkTeam workTeam) {
		workTeamDao.remove(workTeam);
	}
}
