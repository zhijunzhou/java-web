package net.msyy.util;

import net.msyy.model.LessonArrangement;

public class MassMail {

	public static boolean send(String[] maillist, LessonArrangement la) {
		try {
			MyAuthenticator ma = new MyAuthenticator();
		    ma.loadProperties();
		    MailSenderInfo mailInfo = new MailSenderInfo();    
		     mailInfo.setMailServerHost("smtp.163.com");
		     mailInfo.setMailServerPort("25");
		     mailInfo.setValidate(true);
		     mailInfo.setUserName(MyAuthenticator.servermail);
		     mailInfo.setPassword(MyAuthenticator.serverpsd);
		     mailInfo.setFromAddress(MyAuthenticator.servermail);
		     mailInfo.setToAddress(maillist);
		     mailInfo.setSubject("课程提醒通知");//设置主题
		     mailInfo.setContent("尊敬的用户：\n" 
		    		 + "    您注册的课程《 " + la.getLesson().getTitle()
		    		 + "》将在 " + la.getTime() + "准时开课，请届时按时参加！\n寓教于乐！");//设置发送内容
		     //这个类主要来发送邮件
		     SimpleMailSender sms = new SimpleMailSender();   
		     sms.sendTextMail(mailInfo);//发送文体格式    
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
