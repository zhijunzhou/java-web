package net.msyy.common;

public class CommonMessage {

	// session
	public static String OPERATOR_ID = "operator_id";
	
	public static String OPERATOR_SESSION = "operator";
	
	public static String STUDENT_SESSION = "student";
	
	public static String STUDENT_CONTACT_SESSION = "act_contact";
	
	// role
	public static int SYSTEM = 1;
	
	public static int TEACHER = 2;
	
	public static int OPERATOR = 3;
	
	public static int STUDENT = 4;
	
	// http ajax data status
	public static int HTTP_SUCCESS = 0;
	
	public static int HTTP_ERROR = 1;
	
	public static int HTTP_NO_SESSION = 2;
	
	public static int HTTP_R_EXIST = 3;
	
	// lesson status 
	public static int LESSON_STATUS_PRE = -1;
	
	public static int LESSON_STATUS_START = 0;
	
	public static int LESSON_STATUS_END = 1;
}
