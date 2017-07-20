package dao.interfaces;

import java.util.List;

import entity.Employee;
import entity.TeamMember;
import entity.WorkTeam;

public interface ITeamMemberDao extends IDao<TeamMember> {
	
	/*
	 * get team member by its foreign keys
	 */
	public TeamMember getByMember (Long teamId, Long employeeId);
	
	/*
	 * get all members of employee
	 */
	public List<TeamMember> getAllMembersOfEmployee (Employee employee);
	
	/*
	 * get all members from working team
	 */
	public List<TeamMember> getAllMembersFromWorkTeam(WorkTeam workTeam);
}