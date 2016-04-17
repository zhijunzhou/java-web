package net.msyy.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.msyy.common.CommonMessage;
import net.msyy.dao.ManagementInstructionsDao;
import net.msyy.dao.ManagementStatusDao;
import net.msyy.dao.OrganizationTypeDao;
import net.msyy.model.Account;
import net.msyy.model.LessonType;
import net.msyy.model.ManagementInstructions;
import net.msyy.model.ManagementStatus;
import net.msyy.model.Operator;
import net.msyy.model.OrganizationType;
import net.msyy.model.PropertyContact;
import net.msyy.model.PropertyIdentity;
import net.msyy.model.Role;
import net.msyy.model.Student;
import net.msyy.service.AccountService;
import net.msyy.service.LessonService;
import net.msyy.service.PropertyContactService;
import net.msyy.service.PropertyIdentityService;
import net.msyy.service.StudentService;
import net.msyy.service.TeacherService;
import net.msyy.util.DateUtil;
import net.msyy.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("account")
public class AccountController {

	private AccountService accountServiceImpl;

	private TeacherService teacherServiceImpl;

	private ManagementInstructionsDao managementInstructionsDaoImpl;

	private ManagementStatusDao managementStatusDaoImpl;

	private OrganizationTypeDao organizationTypeDaoImpl;

	private PropertyContactService propertyContactServiceImpl;

	private PropertyIdentityService propertyIdentityServiceImpl;

	private LessonService lessonServiceImpl;

	private StudentService studentServiceImpl;

	@Resource
	public void setStudentServiceImpl(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

	@Resource
	public void setLessonServiceImpl(LessonService lessonServiceImpl) {
		this.lessonServiceImpl = lessonServiceImpl;
	}

	@Resource
	public void setPropertyContactServiceImpl(
			PropertyContactService propertyContactServiceImpl) {
		this.propertyContactServiceImpl = propertyContactServiceImpl;
	}

	@Resource
	public void setPropertyIdentityServiceImpl(
			PropertyIdentityService propertyIdentityServiceImpl) {
		this.propertyIdentityServiceImpl = propertyIdentityServiceImpl;
	}

	@Resource
	public void setManagementInstructionsDaoImpl(
			ManagementInstructionsDao managementInstructionsDaoImpl) {
		this.managementInstructionsDaoImpl = managementInstructionsDaoImpl;
	}

	@Resource
	public void setManagementStatusDaoImpl(
			ManagementStatusDao managementStatusDaoImpl) {
		this.managementStatusDaoImpl = managementStatusDaoImpl;
	}

	@Resource
	public void setOrganizationTypeDaoImpl(
			OrganizationTypeDao organizationTypeDaoImpl) {
		this.organizationTypeDaoImpl = organizationTypeDaoImpl;
	}

	@Resource
	public void setTeacherServiceImpl(TeacherService teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
	}

	@Resource
	public void setAccountServiceImpl(AccountService accountServiceImpl) {
		this.accountServiceImpl = accountServiceImpl;
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(String username, String celphone, String email,
			String password) {
		Account account = new Account();

		account.setPassword(MD5Util.MD5(password));
		account.setReg_time(Timestamp.valueOf(DateUtil.getNowDate()));

		Role role = teacherServiceImpl.getRoleById(4);
		account.setRole(role);

		accountServiceImpl.saveAccount(account);

		PropertyContact apc = new PropertyContact();
		apc.setAccount(account);
		apc.setCelphone(celphone);
		apc.setEmail(email);

		PropertyIdentity api = new PropertyIdentity();
		api.setAccount(account);
		api.setNick(username);
		api.setName(username);

		propertyContactServiceImpl.save(apc);
		propertyIdentityServiceImpl.save(api);

		Student stu = new Student();
		stu.setAccount(account);
		studentServiceImpl.save(stu);

		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username,
			@RequestParam String password,
			@RequestParam(required = false) Integer role,
			HttpServletRequest request, HttpSession session) {
		System.out.println("Login with: " + username + " & " + password);
		Object[] result = null;
		if(role != null && role == 4) {
			result = (Object[]) accountServiceImpl.getAccountByParam(username);
		} else {
			result = (Object[]) accountServiceImpl.queryAccountByNickOrCelphone(username);
		}
		
		if (result != null && result.length == 3) {
			Account act = accountServiceImpl.getAccountById((Integer) result[1]);
			
			if(role == null || role == CommonMessage.OPERATOR) {
				if(role == null && act.getRole().getId() != CommonMessage.SYSTEM) {
					// redirect
					
				} else if(role != null && role != CommonMessage.OPERATOR) {
					// redirect
					
				} else {
					if (result[0].equals(MD5Util.MD5(password))) {
						session.setAttribute(CommonMessage.OPERATOR_ID, result[2]);
						PropertyContact apc = propertyContactServiceImpl.getPropertyContactByAccountId((Integer) result[1]);
						session.setAttribute(CommonMessage.OPERATOR_SESSION, apc.getCelphone());
						return "redirect:/teacher/list.do?sid=02";
					}
				}
			} else if (role == CommonMessage.STUDENT) {
				Student student = studentServiceImpl.getStudentById((Integer) result[2]);
				PropertyContact apc = propertyContactServiceImpl.getPropertyContactByAccountId((Integer) result[1]);
				
				session.setAttribute(CommonMessage.STUDENT_CONTACT_SESSION, apc);
				session.setAttribute(CommonMessage.STUDENT_SESSION, student);
				return "redirect:/student/index.do";	
			} else {
				
			}
		}
		// set the default operator
		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
	public String modifyPwd(@RequestParam String pwd1,
			@RequestParam String pwd2, HttpServletRequest request,
			HttpSession session) {
		Integer operator_id = (Integer) session
				.getAttribute(CommonMessage.OPERATOR_ID);
		if (pwd1 != null && pwd2 != null) {
			if (pwd1.equals(pwd2)) {
				Operator operator = teacherServiceImpl
						.getOperatorById(operator_id);
				Account account = operator.getAccount();
				account.setPassword(MD5Util.MD5(pwd1));
				accountServiceImpl.updateAccount(account);
				return "redirect:/login.jsp";
			}
			request.setAttribute("ERROR", "密码不一致");
		} else {
			request.setAttribute("ERROR", "密码不能为空");
		}
		return "/error/error.jsp";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute(CommonMessage.OPERATOR_ID);
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpSession session) {
		session.removeAttribute(CommonMessage.STUDENT_SESSION);
		session.removeAttribute(CommonMessage.STUDENT_CONTACT_SESSION);
		session.invalidate();
		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String initSystem(@RequestParam(required = true) String token,
			HttpServletRequest request) {
		if (token == null) {
			request.setAttribute("ERROR", "非法进入");
			return "/error/error.jsp";
		}
		if (!token.equals(DateUtil.Now())) {
			request.setAttribute("ERROR", "非法进入");
			return "/error/error.jsp";
		}
		if (!isInited()) {
			// init role
			init_role();
			// system account
			if (initSystemAccount() == 0) {
				// 1: management_instructions
				init_management_instructions();

				// 2：
				init_management_status();

				// 3：
				init_organization_type();

				// 4:
				init_lsn_type();

				// 5:
				init_subject();

				return "redirect:/login.jsp";
			}
			request.setAttribute("ERROR", "初始化失败");
		} else {
			request.setAttribute("ERROR", "系统已完成了初始化，请使用管理员账户登录！");
		}
		return "/error/error.jsp";
	}

	private boolean isInited() {
		return accountServiceImpl.getAccountById(1) != null;
	}

	private void init_lsn_type() {
		lessonServiceImpl.saveLessonType(new LessonType("公益课", "公益课"));
		lessonServiceImpl.saveLessonType(new LessonType("线上公开课", "线上公开课"));
		lessonServiceImpl.saveLessonType(new LessonType("一对一辅导", "一对一辅导"));
		lessonServiceImpl.saveLessonType(new LessonType("其它", "其它"));
	}

	private void init_role() {
		// 1 administrator account
		accountServiceImpl.addRole(new Role("admin", "adminstrator"));

		// 2 teacher
		accountServiceImpl.addRole(new Role("teacher", "teacher"));

		// 3 operator
		accountServiceImpl.addRole(new Role("operator", "operator"));

		// 4 student
		accountServiceImpl.addRole(new Role("student", "student"));
	}

	private void init_subject() {
		// lessonServiceImpl.saveSubject(new Subject("语文","语文"));
		// lessonServiceImpl.saveSubject(new Subject("数学","数学"));
		// lessonServiceImpl.saveSubject(new Subject("英语","英语"));
		// lessonServiceImpl.saveSubject(new Subject("政治","政治"));
		// lessonServiceImpl.saveSubject(new Subject("历史","历史"));
		// lessonServiceImpl.saveSubject(new Subject("地理","地理"));
		// lessonServiceImpl.saveSubject(new Subject("物理","物理"));
		// lessonServiceImpl.saveSubject(new Subject("化学","化学"));
		// lessonServiceImpl.saveSubject(new Subject("生物","生物"));
		// lessonServiceImpl.saveSubject(new Subject("其它","其它"));
	}

	private int initSystemAccount() {
		Operator operator = new Operator();
		Account account = new Account();
		account.setPassword(MD5Util.MD5("system"));
		account.setReg_time(Timestamp.valueOf(DateUtil.getNowDate()));

		Role role = teacherServiceImpl.getRoleById(1);
		account.setRole(role);

		operator.setAccount(account);

		accountServiceImpl.saveOperator(operator);

		Operator o = teacherServiceImpl.getOperatorById(1);
		if (o != null) {
			PropertyContact apc = new PropertyContact();
			apc.setCelphone("18086617340");

			PropertyIdentity api = new PropertyIdentity();
			api.setNick("system");
			api.setName("system");

			apc.setAccount(account);
			api.setAccount(account);

			propertyContactServiceImpl.save(apc);
			propertyIdentityServiceImpl.save(api);

			return 0;
		}
		return 1;
	}

	private void init_organization_type() {
		organizationTypeDaoImpl.save(new OrganizationType("公立学校", "公立学校"));
		organizationTypeDaoImpl.save(new OrganizationType("民办学校", "民办学校"));
		organizationTypeDaoImpl.save(new OrganizationType("培训学校", "培训学校"));
		organizationTypeDaoImpl.save(new OrganizationType("独立老师", "独立老师"));
	}

	private void init_management_status() {
		managementStatusDaoImpl.save(new ManagementStatus("已聘", "已聘"));
		managementStatusDaoImpl.save(new ManagementStatus("待聘", "待聘"));
		managementStatusDaoImpl.save(new ManagementStatus("解聘", "解聘"));
		managementStatusDaoImpl.save(new ManagementStatus("已签约", "已签约"));
	}

	private void init_management_instructions() {
		managementInstructionsDaoImpl.save(new ManagementInstructions("跟进",
				"跟进"));
		managementInstructionsDaoImpl.save(new ManagementInstructions("洽谈",
				"洽谈"));
		managementInstructionsDaoImpl.save(new ManagementInstructions("签约",
				"签约"));
	}

}
