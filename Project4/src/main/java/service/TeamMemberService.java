package service;

import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.ITeamMemberDao;
import entity.Employee;
import entity.TeamMember;
import entity.WorkTeam;

public class TeamMemberService {

	private static TeamMemberService teamMemberService = null;
	private static ITeamMemberDao teamMemberDao = null;
	
	private TeamMemberService() {
		teamMemberDao = DaoDBFactory.getInstance().getTeamMemberDao();
	}
	
	public static TeamMemberService getInstance() {
		if (teamMemberService == null) {
			teamMemberService = new TeamMemberService();
		}
		return teamMemberService;
	}
	
	public List<TeamMember> getAll() {
		return teamMemberDao.getAll();
	}
	
	public void add(TeamMember member) {
		teamMemberDao.add(member);
	}
	
	public List<TeamMember> getAllByWorkTeam(WorkTeam workTeam) {
		return teamMemberDao.getAllMembersFromWorkTeam(workTeam);
	}
	
	public List<TeamMember> getAllOfEmployee(Employee employee) {
		return teamMemberDao.getAllMembersOfEmployee(employee);
	}
	
	public void remove(TeamMember teamMember) {
		teamMemberDao.remove(teamMember);
	}
}
