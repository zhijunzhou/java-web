package net.msyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.msyy.dao.AcountDao;
import net.msyy.dao.ManagementInstructionsDao;
import net.msyy.dao.ManagementStatusDao;
import net.msyy.dao.OperationsDao;
import net.msyy.dao.OperatorDao;
import net.msyy.dao.OrganizationDao;
import net.msyy.dao.PropertyContactDao;
import net.msyy.dao.PropertyIdentityDao;
import net.msyy.dao.PropertyMiscDao;
import net.msyy.dao.RoleDao;
import net.msyy.dao.RoleGroupDao;
import net.msyy.dao.TeacherDao;
import net.msyy.model.Account;
import net.msyy.model.ManagementInstructions;
import net.msyy.model.ManagementStatus;
import net.msyy.model.Operations;
import net.msyy.model.Operator;
import net.msyy.model.OrganizationType;
import net.msyy.model.Role;
import net.msyy.model.Teacher;
import net.msyy.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

private AcountDao acountDaoImpl;
	
	private RoleDao roleDaoImpl;
	
	private RoleGroupDao roleGroupDaoImpl;
	
	private PropertyIdentityDao propertyIdentityDaoImpl;
	
	private PropertyContactDao propertyContactDaoImpl;
	
	private PropertyMiscDao propertyMiscDaoImpl;
	
	private OperationsDao operationsDaoImpl;
	
	private OperatorDao operatorDaoImpl;
	
	private OrganizationDao organizationDaoImpl;
	
	private ManagementInstructionsDao managementInstructionsDaoImpl;
	
	private ManagementStatusDao managementStatusDaoImpl;
	
	private TeacherDao teacherDaoImpl;
	
	@Resource
	public void setTeacherDaoImpl(TeacherDao teacherDaoImpl) {
		this.teacherDaoImpl = teacherDaoImpl;
	}

	@Resource
	public void setManagementStatusDaoImpl(
			ManagementStatusDao managementStatusDaoImpl) {
		this.managementStatusDaoImpl = managementStatusDaoImpl;
	}

	@Resource
	public void setOrganizationDaoImpl(OrganizationDao organizationDaoImpl) {
		this.organizationDaoImpl = organizationDaoImpl;
	}

	@Resource
	public void setManagementInstructionsDaoImpl(
			ManagementInstructionsDao managementInstructionsDaoImpl) {
		this.managementInstructionsDaoImpl = managementInstructionsDaoImpl;
	}

	@Resource
	public void setAcountDaoImpl(AcountDao acountDaoImpl) {
		this.acountDaoImpl = acountDaoImpl;
	}

	@Resource
	public void setOperationsDaoImpl(OperationsDao operationsDaoImpl) {
		this.operationsDaoImpl = operationsDaoImpl;
	}

	@Resource
	public void setOperatorDaoImpl(OperatorDao operatorDaoImpl) {
		this.operatorDaoImpl = operatorDaoImpl;
	}

	@Resource
	public void setRoleDaoImpl(RoleDao roleDaoImpl) {
		this.roleDaoImpl = roleDaoImpl;
	}

	@Resource
	public void setRoleGroupDaoImpl(RoleGroupDao roleGroupDaoImpl) {
		this.roleGroupDaoImpl = roleGroupDaoImpl;
	}

	@Resource
	public void setPropertyIdentityDaoImpl(
			PropertyIdentityDao propertyIdentityDaoImpl) {
		this.propertyIdentityDaoImpl = propertyIdentityDaoImpl;
	}

	@Resource
	public void setPropertyContactDaoImpl(PropertyContactDao propertyContactDaoImpl) {
		this.propertyContactDaoImpl = propertyContactDaoImpl;
	}

	@Resource
	public void setPropertyMiscDaoImpl(PropertyMiscDao propertyMiscDaoImpl) {
		this.propertyMiscDaoImpl = propertyMiscDaoImpl;
	}

	@Override
	public void newTeacher(Teacher teacher) throws Exception {
		try {
			teacherDaoImpl.save(teacher);			
		} catch (Exception e) {
			throw new Exception("保存教师信息失败！");
		}	
	}

	@Override
	public void updateTeacher(Teacher teacher) throws Exception {
		try {
			teacherDaoImpl.update(teacher);			
		} catch (Exception e) {
			throw new Exception("更新教师信息失败！");
		}	
	}

	@Override
	public List<Teacher> queryTeacher(String name, String celphone,
			String social_code, String teacher_id) throws Exception {
		try {
			teacherDaoImpl.findAll(Teacher.class, 
					new String[]{"name","celphone","social_code","teacher_id"},
					new Object[]{name, celphone, social_code, teacher_id});
		} catch (Exception e) {
			throw new Exception("查询教师信息发生异常！");
		}
		return null;
	}

	@Override
	public List<Teacher> queryAllTeacher() {
		List<Teacher> teachers = teacherDaoImpl.findAll(Teacher.class);
		return teachers;
	}

	@Override
	public List queryAllTeacherBySql() {		
		return queryTeacherByType(4,null);
	}

	@Override
	public List queryTeacherBySql(String param) {
		return queryTeacherByType(4,param);
	}
	
	private List queryTeacherByType(int type, String param) {
		String sql = 
			"select " + 
		        "result.teaid0,result.account_id,result.contact_id, " +
		        "result.identity_id,result.misc_id,result.name0, " +
		        "result.celphone0,result.name1,result.name2,result.org_type_id, " +
		        "mi.name as name3,apc2.name as name4,opts.op_time " +
		    "from " + 
		        "(select " + 
		            "tea.teacher_id as teaid0, " + 
		            "act.account_id, " + 
		            "apc.contact_id, " + 
		            "api.identity_id, " + 
		            "apm.misc_id, " + 
		            "api.name as name0, " + 
		            "apc.celphone as celphone0, " + 
		            "org.name as name1, " + 
		            "mgtus.name as name2, " + 
		            "org.organization_type_id as org_type_id " + 
		        "from " + 
		           " account as act   " + 
		        "inner join " + 
		            "account_property_contact apc  " + 
		                "on  apc.account_id = act.account_id  " + 
		       " inner join " + 
		            "account_property_misc as apm  " + 
		                "on apm.account_id = act.account_id  " + 
		        "inner join " + 
		            "account_property_identity as api  " + 
		                "on api.account_id = act.account_id  " + 
		        "inner join " + 
		            "teacher as tea  " + 
		                "on    tea.account_id = act.account_id  " + 
		        "join " + 
			            "management_status as mgtus  " + 
			                "on  tea.management_status_id = mgtus.management_status_id  " + 
		        "inner join " + 
		            "organization as org  " + 
		                "on    org.organization_id = tea.organization_id";
		if(param != null && !param.trim().equals("")) {
			sql += " where apc.celphone like '%"+param+"%' ";
			sql += " or tea.teacher_id like '%"+param+"%' ";
			sql += " or api.name like '%"+param+"%' ";
		}
		sql = sql + " ) as result " +
			",operations as opts " + 
			" inner join management_instructions as mi on " +
			"	opts.instructions_id = mi.instructions_id " +
			" inner join operator as opr1 on " +
			"	opts.operator_id = opr1.operator_id " +
			" inner join account as act2 on " +
			"	opr1.account_id = act2.account_id " +
			" inner join account_property_identity as apc2 on " +
			"	apc2.account_id = act2.account_id ";
		if(type >=4) {
			sql += " where result.org_type_id >= 4 ";
		} else {
			sql += " where result.org_type_id < 4 ";
		}
		sql = sql +  
			" and opts.operations_id in " + 
			" (select MAX(operations_id) from operations where teacher_id=result.teaid0) " + 
			"group by " + 
			"result.teaid0,result.account_id,result.contact_id, " +
	        "result.identity_id,result.misc_id,result.name0, " +
	        "result.celphone0,result.name1,result.name2,result.org_type_id, " +
	        "mi.name,apc2.name,opts.op_time ";
		return teacherDaoImpl.findAllBySql(sql);        
	}
	
	@Override
	public List recentOperations(Teacher teacher) {
		String sql = ""+
		"select " + 
			"opts.teacher_id,mgtinsts.name as name3,api1.name as name2,opts.op_time  " + 
		"from " + 
		"teacher as tea		 " + 
				"inner join account as act on " + 
					"act.account_id = tea.account_id " + 
				"inner join operations as opts on " + 
					"opts.teacher_id = tea.teacher_id " + 
				"inner join operator as opr on " + 
					"opts.operator_id = opr.operator_id " + 
				"inner join management_instructions as mgtinsts on " + 
					"opts.instructions_id = mgtinsts.instructions_id " + 
				"inner join account as act1 on  " + 
					"opr.account_id = act1.account_id " + 
				"inner join account_property_identity as api1 on " + 
					"opr.account_id = api1.account_id " +
				" where tea.teacher_id=" + teacher.getId();
		return teacherDaoImpl.findAllBySql(sql);
	}

	@Override
	public Teacher getTeacherById(int id) {
		return (Teacher) teacherDaoImpl.findById(Teacher.class, id);
	}

	@Override
	public Operator getOperatorById(int id) {
		return (Operator) operatorDaoImpl.findById(Operator.class, id);
	}

	@Override
	public void newOperation(Operations operations) {
		operationsDaoImpl.save(operations);
	}

	@Override
	public ManagementInstructions getManagementInstructionsById(int id) {
		return (ManagementInstructions) managementInstructionsDaoImpl.findById(ManagementInstructions.class, id);
	}

	@Override
	public OrganizationType getOrganizationTypeById(int id) {
		return (OrganizationType) organizationDaoImpl.findById(OrganizationType.class, id); 
	}

	@Override
	public List queryAllOrgBySql() {
		return this.queryTeacherByType(1, null);
	}

	@Override
	public List queryOrgBySql(String param) {
		return queryTeacherByType(1, param);
	}

	@Override
	public List queryOperatorOperations(Operator operator) {
		String sql =
			"select api.name as name0,op_time,mgts.name as name1,apc.celphone,op_detail from operations as opts "+
			"inner join teacher as tea on "+
				"tea.teacher_id = opts.teacher_id "+
			"inner join management_instructions as mgts on "+
				"mgts.instructions_id = opts.instructions_id "+
			"inner join operator as opr on "+
				"opr.operator_id = opts.operator_id "+
			"inner join account_property_identity as api on "+
				"tea.account_id = api.account_id "+
			"inner join account_property_contact as apc on "+
				"tea.account_id = apc.account_id "+
			"and opr.operator_id = " + operator.getId() + 
			" order by op_time desc ";
		return operatorDaoImpl.findAllBySql(sql);
	}

	@Override
	public ManagementStatus getManagementStatusById(int id) {
		return (ManagementStatus) managementStatusDaoImpl.findById(ManagementStatus.class, id);
	}

	@Override
	public void newOperator(Operator operator) {
		operatorDaoImpl.save(operator);
	}

	@Override
	public Role getRoleById(int id) {
		return (Role) roleDaoImpl.findById(Role.class, id);
	}
}
 /**
  * select
        result.teaid0,result.account_id,result.celphone0,
        result.contact_id,result.identity_id,result.misc_id,
        result.name0,result.name1,result.name2,result.org_type_id,
        opts.op_detail,opts.operations_id,opts.op_time
    from
        (select
            tea.teacher_id as teaid0,
            act.account_id,
            apc.contact_id,
            api.identity_id,
            apm.misc_id,
            api.name as name0,
            apc.celphone as celphone0,
            org.name as name1,
            mgtus.name as name2,
            org.organization_type_id as org_type_id            
        from
            account as act   
        inner join
            account_property_contact apc  
                on  apc.account_id = act.account_id   
        inner join
            account_property_misc as apm  
                on apm.account_id = act.account_id  
        inner join
            account_property_identity as api  
                on api.account_id = act.account_id  
        inner join
            teacher as tea  
                on    tea.account_id = act.account_id  
        join
            management_status as mgtus  
                on  tea.management_status_id = mgtus.management_status_id  
        inner join
            organization as org  
                on    org.organization_id = tea.organization_id 
         ) 
         as result,
         operations as opts 
    where
        opts.operations_id in 
        
        (select MAX(operations_id) from operations where teacher_id=result.teaid0)
        
        group by result.teaid0,result.account_id,result.celphone0,
        result.contact_id,result.identity_id,result.misc_id,
        result.name0,result.name1,result.name2,result.org_type_id,
        opts.op_detail,opts.op_time,opts.operations_id
  
**/