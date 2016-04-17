package net.msyy.service;

import java.util.List;

import net.msyy.model.ManagementInstructions;
import net.msyy.model.ManagementStatus;
import net.msyy.model.Operations;
import net.msyy.model.Operator;
import net.msyy.model.OrganizationType;
import net.msyy.model.Role;
import net.msyy.model.Teacher;

public interface TeacherService {

	public void newTeacher(Teacher teacher) throws Exception;
	
	public void newOperator(Operator operator);
	
	public void newOperation(Operations operations);

	public void updateTeacher(Teacher teacher) throws Exception;

	public List<Teacher> queryAllTeacher();
	
	public Role getRoleById(int id);
	
	public Teacher getTeacherById(int id);
	
	public Operator getOperatorById(int id);
	
	public OrganizationType getOrganizationTypeById(int id);
	
	public ManagementInstructions getManagementInstructionsById(int id);
	
	public ManagementStatus getManagementStatusById(int id);
	
	public List<Teacher> queryTeacher(String name, String celphone,
			String social_code, String teacher_id) throws Exception;
	
	public List queryAllTeacherBySql();
	
	public List queryTeacherBySql(String param);
	
	public List queryAllOrgBySql();
	
	public List queryOrgBySql(String param);
	
	public List queryOperatorOperations(Operator operator);
	
	public List recentOperations(Teacher teacher);
}
 