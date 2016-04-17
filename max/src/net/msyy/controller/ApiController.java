package net.msyy.controller;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.msyy.dao.ManagementInstructionsDao;
import net.msyy.dao.ManagementStatusDao;
import net.msyy.dao.OrganizationTypeDao;
import net.msyy.model.Account;
import net.msyy.model.PropertyContact;
import net.msyy.model.PropertyIdentity;
import net.msyy.model.Role;
import net.msyy.model.Student;
import net.msyy.model.Teacher;
import net.msyy.service.AccountService;
import net.msyy.service.LessonService;
import net.msyy.service.PropertyContactService;
import net.msyy.service.PropertyIdentityService;
import net.msyy.service.PropertyMiscService;
import net.msyy.service.StudentService;
import net.msyy.service.TeacherService;
import net.msyy.util.DateUtil;
import net.msyy.util.ExceUtil;
import net.msyy.util.FileUpload;
import net.msyy.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("api")
public class ApiController {

	private AccountService accountServiceImpl;
	
	private TeacherService teacherServiceImpl;
	
	private ManagementInstructionsDao managementInstructionsDaoImpl;
	
	private ManagementStatusDao managementStatusDaoImpl;
	
	private OrganizationTypeDao organizationTypeDaoImpl;
	
	private PropertyContactService propertyContactServiceImpl;
	
	private PropertyIdentityService propertyIdentityServiceImpl;
	
	private PropertyMiscService propertyMiscServiceImpl;
	
	private LessonService lessonServiceImpl;
	
	private StudentService studentServiceImpl;

	@Resource
	public void setAccountServiceImpl(AccountService accountServiceImpl) {
		this.accountServiceImpl = accountServiceImpl;
	}

	@Resource
	public void setTeacherServiceImpl(TeacherService teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
	}

	@Resource
	public void setManagementInstructionsDaoImpl(
			ManagementInstructionsDao managementInstructionsDaoImpl) {
		this.managementInstructionsDaoImpl = managementInstructionsDaoImpl;
	}

	@Resource
	public void setStudentServiceImpl(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
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

	@Resource
	public void setLessonServiceImpl(LessonService lessonServiceImpl) {
		this.lessonServiceImpl = lessonServiceImpl;
	}
	
	/**
	 * Account
	 */
	
	
	/***
	 * Teacher
	 */
	
	/**
	 * http://localhost:8080/CSIPM/api/teachers.do
	 */
	@ResponseBody
	@RequestMapping(value="/teachers",method=RequestMethod.GET)
	public List<Teacher> teachers(HttpServletRequest request) {
		List<Teacher> teachers = teacherServiceImpl.queryAllTeacherBySql();
		return teachers;
	}
	
	/**
	 * http://localhost:8080/CSIPM/api/teachers/param.do?param=1
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/teachers/param")
	public List<Teacher> teachers(@RequestParam String param,HttpServletRequest request) {
		List<Teacher> teachers = teacherServiceImpl.queryTeacherBySql(param);
		return teachers;
	}
	
	/**
	 * Operator
	 */
	
	/**
	 * Lesson
	 */
	@ResponseBody
	@RequestMapping(value="/lessons")
	public List<Teacher> lessons(@RequestParam(required = false) String startdate,
			@RequestParam(required = false) String enddate,
			@RequestParam(required = false) Integer rank) {
		if(rank == null) rank = 0;
		List list = lessonServiceImpl.queryLessonListByDate(startdate, enddate,
				rank);
		return list;
	}
	
	/**
	 * Student 
	 */
	@ResponseBody
	@RequestMapping(value="/importStudentsFromExcel")
	public int importStudentsFromExcel(@RequestParam(value = "excelFile", required = true) MultipartFile excelFile,
			HttpServletRequest request,HttpSession session) {
		try {
			String tempPath = uploadFile(request,excelFile);
			String path = session.getServletContext().getRealPath("upload/excel/");
			List dict = ExceUtil.readExcel(path + "/" + tempPath);
			for(Iterator it = dict.iterator();it.hasNext();) {
				Object[] arr = (Object[]) it.next();
				saveStudent(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	private void saveStudent(Object[] arr) {
		Account account = new Account();

		account.setPassword(MD5Util.MD5("123456"));
		account.setReg_time(Timestamp.valueOf(DateUtil.getNowDate()));

		Role role = teacherServiceImpl.getRoleById(4);
		account.setRole(role);

		accountServiceImpl.saveAccount(account);

		PropertyContact apc = new PropertyContact();
		apc.setAccount(account);
		apc.setCelphone((String) arr[1]);
		apc.setEmail((String) arr[2]);

		PropertyIdentity api = new PropertyIdentity();
		api.setAccount(account);
		api.setNick((String) arr[0]);
		api.setName((String) arr[0]);

		propertyContactServiceImpl.save(apc);
		propertyIdentityServiceImpl.save(api);

		Student stu = new Student();
		stu.setAccount(account);
		studentServiceImpl.save(stu);
	}

	public String uploadFile(HttpServletRequest request, MultipartFile fileAddr)
		throws Exception {
		String path = request.getSession().getServletContext()
				.getRealPath("upload/excel/");
		String newName = DateUtil.flow()
				+ fileAddr.getOriginalFilename().substring(
						fileAddr.getOriginalFilename().lastIndexOf("."));
		FileUpload.upload(path, newName, fileAddr);
		return newName;
	}
	
}
