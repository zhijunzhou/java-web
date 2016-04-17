package net.msyy.aop;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.msyy.common.CommonMessage;
import net.msyy.model.Student;

import org.apache.log4j.Logger;

public class PermissionFilter implements Filter {
	
	private Logger logger= Logger.getLogger(PermissionFilter.class);  

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request= (HttpServletRequest) req;  
        String uri = request.getRequestURI();
        if(uri.contains(".do") || uri.contains(".jsp")) {
        	System.out.print(request.getRemoteHost() + " ");
        	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        	System.out.println(uri);
        }
        HttpSession session = request.getSession();
        Integer operator_id = (Integer) session.getAttribute(CommonMessage.OPERATOR_ID);
        Student student = (Student) session.getAttribute(CommonMessage.STUDENT_SESSION);
        boolean flag = true;
        if(uri.contains(".do")) {
        	// init system don't need session
        	if(uri.contains("reg.do")) {
        		
        	} else if(uri.contains("init.do")) {
        		
        	} else if(uri.contains("index.do")) {
        		
        	} else if(uri.contains("login.do")){
        		
        	} else if(uri.contains("api")) { // call the api don't need session
        		
        	} else {
        		if(operator_id == null) {
        			HttpServletResponse response = (HttpServletResponse) resp;
        			if(uri.contains("/operation/") || uri.contains("/organization/") 
        					|| uri.contains("/teacher/") || uri.contains("/account/")) {
        				System.out.println("Access is denied!");
        	    		response.sendRedirect("../login.jsp");	
        	    		flag = false;
        			}
        			if(uri.contains("/lesson/")) {
        				if(uri.contains("addLesson.do")) {
        					response.sendRedirect("../login.jsp");	
        					flag = false;
        				}
        			}
        		}
        	}
        }
        if(flag) filterChain.doFilter(request, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init filter");
	}

}
