package net.msyy.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.msyy.common.CommonMessage;
import net.msyy.dao.OperatorDao;
import net.msyy.model.Account;
import net.msyy.model.ManagementInstructions;
import net.msyy.model.ManagementStatus;
import net.msyy.model.Operations;
import net.msyy.model.Operator;
import net.msyy.model.Organization;
import net.msyy.model.OrganizationType;
import net.msyy.model.PropertyContact;
import net.msyy.model.PropertyIdentity;
import net.msyy.model.PropertyMisc;
import net.msyy.model.Role;
import net.msyy.model.Teacher;
import net.msyy.service.AccountService;
import net.msyy.service.LessonService;
import net.msyy.service.PropertyContactService;
import net.msyy.service.PropertyIdentityService;
import net.msyy.service.PropertyMiscService;
import net.msyy.service.TeacherService;
import net.msyy.util.DateUtil;
import net.msyy.util.FileUpload;
import net.msyy.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("teacher")
public class TeacherController {

	private TeacherService teacherServiceImpl;
	
	private PropertyContactService propertyContactServiceImpl;
	
	private PropertyIdentityService propertyIdentityServiceImpl;
	
	private PropertyMiscService propertyMiscServiceImpl;
	
	private AccountService accountServiceImpl;
	
	private LessonService lessonServiceImpl;
	
	@Resource
	public void setLessonServiceImpl(LessonService lessonServiceImpl) {
		this.lessonServiceImpl = lessonServiceImpl;
	}

	@Resource
	public void setAccountServiceImpl(AccountService accountServiceImpl) {
		this.accountServiceImpl = accountServiceImpl;
	}

	@Resource
	public void setTeacherServiceImpl(TeacherService teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
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
	public void setPropertyMiscServiceImpl(
			PropertyMiscService propertyMiscServiceImpl) {
		this.propertyMiscServiceImpl = propertyMiscServiceImpl;
	}

	/**
	 * 
	 * @param name in PropertyIdentity
	 * @param avatar_url in PropertyMisc
	 * @param celphone in PropertyContact
	 * @param birthday in PropertyIdentity
	 * @param loc_id in PropertyContact
	 * @param org_name in Organization
	 * @param title in OrganizationType
	 * @return 
	 * @throws ParseException 
	 */
	@RequestMapping(value="/addTeacher",method=RequestMethod.POST)
	public String addTeacher(@RequestParam String name,
			@RequestParam String celphone,@RequestParam(required=false) String birthday,
			@RequestParam String loc_id,@RequestParam String org_name,
			@RequestParam(value="avatar_url",required=false) MultipartFile avatar_url_file,
			@RequestParam Integer org_type, HttpServletRequest request, HttpSession session) throws ParseException {
		// after save a teacher
		Integer operator_id = (Integer) session.getAttribute("operator_id");
		if(operator_id == null) {
			request.setAttribute("ERROR", "请重新登陆！");
			return "/error/error.jsp";
		}
		List list = accountServiceImpl.getAccountByCelphone(celphone);
		if(list != null && list.size() > 0) {
			request.setAttribute("ERROR", "手机号已被注册！");
			return "/error/error.jsp";
		}
		Teacher teacher = new Teacher();
		PropertyIdentity pi = new PropertyIdentity();
		PropertyMisc pm = new PropertyMisc();
		PropertyContact pc = new PropertyContact();
		Organization org = new Organization();
		ManagementStatus mgtus = teacherServiceImpl.getManagementStatusById(2);
		OrganizationType orgType = teacherServiceImpl.getOrganizationTypeById(org_type);
		// 
		Account ac = new Account();
		// register time generate
		ac.setReg_time(Timestamp.valueOf(DateUtil.getNowDate()));
		// set teacher name
		pi.setName(name);
		// personal pic url
		String avatar_url = null; 
		if(avatar_url_file != null && avatar_url_file.getSize() > 0) {
			try {
				avatar_url = uploadImage(request, avatar_url_file);
			} catch (Exception e) {
				System.out.println("File upload file!");
			}
		}
		pm.setAvatar_url(avatar_url);
		// set celphone & loc_id
		pc.setCelphone(celphone);
		pc.setLoc_id(loc_id);
		// set birthday
		if(birthday != null && !birthday.equals(""))
			pi.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		// set org_name
		org.setName(org_name);

		pi.setAccount(ac);
		pm.setAccount(ac);
		pc.setAccount(ac);
		
		// set default management
		teacher.setManagementStatus(mgtus);
		
		teacher.setAccount(ac);
		org.setOrg_type(orgType);
		teacher.setOrganization(org);	
		try {
			teacherServiceImpl.newTeacher(teacher);
			propertyContactServiceImpl.save(pc);
			propertyIdentityServiceImpl.save(pi);
			propertyMiscServiceImpl.save(pm);
			
			
			Operator operator = teacherServiceImpl.getOperatorById(operator_id);
			Operations operations = new Operations();
			ManagementInstructions instructions = teacherServiceImpl.getManagementInstructionsById(1); // default ins
			operations.setManagementInstructions(instructions);
			operations.setTeacher(teacher);
			operations.setOp_detail("首次跟进");
			operations.setOp_time(Timestamp.valueOf(DateUtil.getNowDate()));
			operations.setOperator(operator);
			teacherServiceImpl.newOperation(operations);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(org_type < 4) {
			return "redirect:/teacher/orgList.do";
		}
		return "redirect:/teacher/list.do";
	}
	
	public String uploadImage(HttpServletRequest request,MultipartFile imgAddr) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("upload/");
		String newName = DateUtil.flow() + imgAddr.getOriginalFilename()
							.substring(imgAddr.getOriginalFilename().lastIndexOf("."));
		FileUpload.upload(path, newName, imgAddr);
		return newName;
	}
	
	@RequestMapping(value="/updateTeacher",method=RequestMethod.POST)
	public String updateTeacher(@RequestParam Integer teacher_id,@RequestParam Integer mgt_status_id,
			@RequestParam Integer contact_id,@RequestParam  Integer identity_id,
			@RequestParam Integer misc_id,@RequestParam String name,
			@RequestParam(value="avatar_url",required=false) MultipartFile avatar_url_file,
			@RequestParam String celphone,@RequestParam(required=false) String birthday,
			@RequestParam String loc_id,@RequestParam String org_name,
			@RequestParam Integer org_type, HttpServletRequest request) throws ParseException {
		Teacher teacher = teacherServiceImpl.getTeacherById(teacher_id);
		PropertyIdentity pi = propertyIdentityServiceImpl.getPropertyIdentityById(identity_id);
		PropertyMisc pm = propertyMiscServiceImpl.getPropertyMiscById(misc_id);
		PropertyContact pc = propertyContactServiceImpl.getPropertyContactById(contact_id);
		Organization org = teacher.getOrganization();
		OrganizationType orgType = teacherServiceImpl.getOrganizationTypeById(org_type);
		ManagementStatus mgtus = teacherServiceImpl.getManagementStatusById(mgt_status_id);
		// set teacher name
		pi.setName(name);
		// personal pic url
		String avatar_url = null; 
		if(avatar_url_file != null && avatar_url_file.getSize() > 0) {
			try {
				avatar_url = uploadImage(request, avatar_url_file);
			} catch (Exception e) {
				System.out.println("File upload file!");
			}
			pm.setAvatar_url(avatar_url);
		}
		// set celphone & loc_id
		pc.setCelphone(celphone);
		pc.setLoc_id(loc_id);
		// set birthday
		if(birthday != null && !birthday.equals(""))
			pi.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		// set org_name
		org.setName(org_name);
		org.setOrg_type(orgType);
		teacher.setManagementStatus(mgtus);
		teacher.setOrganization(org);	
		try {
			teacherServiceImpl.updateTeacher(teacher);
			propertyContactServiceImpl.update(pc);
			propertyIdentityServiceImpl.update(pi);
			propertyMiscServiceImpl.update(pm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(org_type < 4) {
			return "redirect:/teacher/orgList.do";
		}
		return "redirect:/teacher/list.do";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getAllTeacher(HttpServletRequest request) {
		List<Teacher> teachers = teacherServiceImpl.queryAllTeacherBySql();
		request.setAttribute("teachers", teachers);
		return "/teacher/main.jsp";
	}
	
	@RequestMapping(value="/orgList",method=RequestMethod.GET)
	public String getAllOrg(HttpServletRequest request) {
		List<Teacher> orgs = teacherServiceImpl.queryAllOrgBySql();
		request.setAttribute("orgs", orgs);
		return "/organization/main.jsp";
	}
	
	@RequestMapping(value="/orgFilterList",method=RequestMethod.POST)
	public String orgFilterList(String param,HttpServletRequest request) {
		List<Teacher> orgs = teacherServiceImpl.queryOrgBySql(param);
		request.setAttribute("orgs", orgs);
		return "/organization/main.jsp";
	}
	
	@RequestMapping(value="/filterlist")
	public String getFilteredTeacher(String param,HttpServletRequest request) {
		List<Teacher> teachers = teacherServiceImpl.queryTeacherBySql(param);
		request.setAttribute("teachers", teachers);
		return "/teacher/main.jsp";
	}
	
	@RequestMapping(value="/viewTeacher",method=RequestMethod.GET)
	public String viewTeacher(@RequestParam Integer teacher_id,@RequestParam  Integer account_id,
			@RequestParam Integer contact_id,@RequestParam  Integer identity_id,
			@RequestParam Integer misc_id,HttpServletRequest request) {
		Teacher teacher;
		Account account;
		PropertyContact contact;
		PropertyIdentity identity;
		PropertyMisc misc;
		teacher = teacherServiceImpl.getTeacherById(teacher_id);
		account = teacher.getAccount();
		contact = propertyContactServiceImpl.getPropertyContactById(contact_id);
		identity = propertyIdentityServiceImpl.getPropertyIdentityById(identity_id);
		misc = propertyMiscServiceImpl.getPropertyMiscById(misc_id);
		request.setAttribute("teacher", teacher);
		request.setAttribute("account", account);
		request.setAttribute("contact", contact);
		request.setAttribute("identity", identity);
		request.setAttribute("misc", misc);
		
		// generate chart
		List data1 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, 1);
		List data2 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, 2);
		List data3 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, 3);
		List data4 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, -1);
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("data4", data4);
		return "/teacher/viewTeacher.jsp";
	}
	
	@RequestMapping(value="/viewTeacherById",method=RequestMethod.GET)
	public String viewTeacherById(@RequestParam Integer teacher_id,HttpServletRequest request) {
		Teacher teacher;
		Account account;
		PropertyContact contact = null;
		PropertyIdentity identity = null;
		PropertyMisc misc = null;
		
		teacher = teacherServiceImpl.getTeacherById(teacher_id);
		account = teacher.getAccount();
		// TODO
		contact = propertyContactServiceImpl.getPropertyContactByAccountId(account.getId());
		identity = propertyIdentityServiceImpl.getPropertyIdentityById((Integer) propertyIdentityServiceImpl.getPropertyIdentityByAccountId(account.getId()));
		misc = propertyMiscServiceImpl.getPropertyMiscById((Integer) propertyMiscServiceImpl.getPropertyMiscByAccountId(account.getId()));
		request.setAttribute("teacher", teacher);
		request.setAttribute("account", account);
		request.setAttribute("contact", contact);
		request.setAttribute("identity", identity);
		request.setAttribute("misc", misc);
		
		// generate chart
		List data1 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, 1);
		List data2 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, 2);
		List data3 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, 3);
		List data4 = lessonServiceImpl.getLessonCountByTeacherAndLessonType(teacher_id, -1);
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("data4", data4);
		
		return "/teacher/viewTeacher.jsp";
	}
	
	@RequestMapping(value="/updatingTeacher",method=RequestMethod.GET)
	public String updatingTeacher(@RequestParam Integer teacher_id,@RequestParam  Integer account_id,
			@RequestParam Integer contact_id,@RequestParam  Integer identity_id,
			@RequestParam Integer misc_id,HttpServletRequest request) {
		Teacher teacher;
		Account account;
		PropertyContact contact;
		PropertyIdentity identity;
		PropertyMisc misc;
		teacher = teacherServiceImpl.getTeacherById(teacher_id);
		account = teacher.getAccount();
		contact = propertyContactServiceImpl.getPropertyContactById(contact_id);
		identity = propertyIdentityServiceImpl.getPropertyIdentityById(identity_id);
		misc = propertyMiscServiceImpl.getPropertyMiscById(misc_id);
		request.setAttribute("teacher", teacher);
		request.setAttribute("account", account);
		request.setAttribute("contact", contact);
		request.setAttribute("identity", identity);
		request.setAttribute("misc", misc);
		return "/teacher/updateTeacher.jsp";
	}
	
	@RequestMapping(value="/updatingOrg",method=RequestMethod.GET)
	public String updatingOrg(@RequestParam Integer teacher_id,@RequestParam  Integer account_id,
			@RequestParam Integer contact_id,@RequestParam  Integer identity_id,
			@RequestParam Integer misc_id,HttpServletRequest request) {
		Teacher teacher;
		Account account;
		PropertyContact contact;
		PropertyIdentity identity;
		PropertyMisc misc;
		teacher = teacherServiceImpl.getTeacherById(teacher_id);
		account = teacher.getAccount();
		contact = propertyContactServiceImpl.getPropertyContactById(contact_id);
		identity = propertyIdentityServiceImpl.getPropertyIdentityById(identity_id);
		misc = propertyMiscServiceImpl.getPropertyMiscById(misc_id);
		request.setAttribute("teacher", teacher);
		request.setAttribute("account", account);
		request.setAttribute("contact", contact);
		request.setAttribute("identity", identity);
		request.setAttribute("misc", misc);
		return "/organization/updateTeacher.jsp";
	}
	
	@RequestMapping(value="/operatingTeacher",method=RequestMethod.GET)
	public String operatingTeacher(@RequestParam Integer teacher_id,HttpServletRequest request) {
		Teacher teacher = teacherServiceImpl.getTeacherById(teacher_id);
		List operations = teacherServiceImpl.recentOperations(teacher);
		request.setAttribute("teacher_id", teacher_id);
		request.setAttribute("operations", operations);
		return "/teacher/operateTeacher.jsp";
	}
	
	@RequestMapping(value="/operateTeacher",method=RequestMethod.POST)
	public String operateTeacher(@RequestParam Integer name, @RequestParam String op_detail, 
			@RequestParam Integer teacher_id,HttpServletRequest request, HttpSession session) {
		Integer operator_id = (Integer) session.getAttribute("operator_id");
		if(operator_id == null) {
			request.setAttribute("ERROR", "请重新登陆！");
			return "/error/error.jsp";
		}
		Operations operations = new Operations();
		// get operator by id
		Operator operator = teacherServiceImpl.getOperatorById(operator_id);
		// get teacher by teacher id
		Teacher teacher = teacherServiceImpl.getTeacherById(teacher_id);
		
		ManagementInstructions instructions = teacherServiceImpl.getManagementInstructionsById(name);
		
		operations.setManagementInstructions(instructions);
		operations.setTeacher(teacher);
		operations.setOp_detail(op_detail);
		operations.setOp_time(Timestamp.valueOf(DateUtil.getNowDate()));
		operations.setOperator(operator);
		
		teacherServiceImpl.newOperation(operations);
		
		return "redirect:/teacher/operatingTeacher.do?teacher_id=" + teacher_id;
	}
	
	@RequestMapping(value="/getOperatorOperations")
	public String getOperatorOperations(HttpServletRequest request, HttpSession session) {
		Integer operator_id = (Integer) session.getAttribute("operator_id");
		if(operator_id == null) {
			request.setAttribute("ERROR", "请重新登陆！");
			return "/error/error.jsp";
		}
		Operator opr = teacherServiceImpl.getOperatorById(operator_id);
		if(opr != null) {
			List list =  teacherServiceImpl.queryOperatorOperations(opr);
			request.setAttribute("operations", list);
			return "/operation/main.jsp";
		}		
		request.setAttribute("ERROR", "error:" + opr);
		return "/error/error.jsp";
	}
	
	@RequestMapping(value="/newOperator",method=RequestMethod.GET)
	public String newOperator(HttpServletRequest request, HttpSession session) {
		Integer operator_id = (Integer) session.getAttribute("operator_id");
		if(operator_id == null) {
			request.setAttribute("ERROR", "请重新登陆！");
			return "/error/error.jsp";
		}
		if(operator_id != 1) {
			request.setAttribute("ERROR", "权限不足，请联系管理员！");
			return "/error/error.jsp";
		}
		return "/operation/newOperator.jsp";
	}
	
	@RequestMapping(value="/addOperator",method=RequestMethod.POST)
	public String addOperator(String name,String loc_id, 
			String org_name,String celphone,
			HttpServletRequest request, HttpSession session) {
		Integer operator_id = (Integer) session.getAttribute("operator_id");
		if(operator_id == null) {
			request.setAttribute("ERROR", "请重新登陆！");
			return "/error/error.jsp";
		}
		Operator oprSys = teacherServiceImpl.getOperatorById(operator_id);
		try {
			int limit = oprSys.getAccount().getRole().getId();
			if(limit != 1) {
				request.setAttribute("ERROR", "权限不足，请联系管理员！");
				return "/error/error.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("ERROR", "权限不足，请联系管理员！");
			return "/error/error.jsp";
		}		
		List list = accountServiceImpl.getAccountByCelphone(celphone);
		if(list != null && list.size() > 0) {
			request.setAttribute("ERROR", "手机号已被注册！");
			return "/error/error.jsp";
		}
		Operator opr = new Operator();
		Account account = new Account();
		account.setReg_time(Timestamp.valueOf(DateUtil.getNowDate()));
		account.setPassword(MD5Util.MD5("12345678"));
		Role role = teacherServiceImpl.getRoleById(CommonMessage.OPERATOR);
		account.setRole(role);
		
		PropertyContact apc = new PropertyContact();
		apc.setCelphone(celphone);
		
		PropertyIdentity api = new PropertyIdentity();
		api.setName(name);
		
		apc.setAccount(account);
		api.setAccount(account);
		opr.setAccount(account);
		propertyContactServiceImpl.save(apc);
		propertyIdentityServiceImpl.save(api);
		accountServiceImpl.saveOperator(opr);
		request.setAttribute("status", "添加成功！");
		request.setAttribute("username", celphone);
		request.setAttribute("pwd", "12345678");
		return "/operation/newOperator.jsp";
	}
	
}