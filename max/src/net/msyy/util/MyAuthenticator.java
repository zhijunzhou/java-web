package net.msyy.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	String userName=null;   
    String password=null;   
    public static String servermail = null;
    public static String serverpsd = null;
        
    public MyAuthenticator(){   
    }   
    
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
    
    public void loadProperties () {
    	Properties props = new Properties();
    	String url = this.getClass().getClassLoader().getResource("mail.properties").toString().substring(6);
    	String empUrl = url.replace("%20", " ");
    	System.out.println(empUrl);  
    	InputStream in = null;  
    	try {
    		in = new BufferedInputStream(new FileInputStream(empUrl));
    		props.load(in);
//    		System.out.println(props.getProperty("servermail"));
//    		System.out.println(props.getProperty("serverpsd"));
    		servermail = props.getProperty("servermail");
    		serverpsd = props.getProperty("serverpsd");
    	} catch (FileNotFoundException e1) {
    		e1.printStackTrace();
    	} catch (IOException e1) {
    		e1.printStackTrace();  
    	}
    }
    
    public static void main(String[] args){
     MyAuthenticator ma = new MyAuthenticator();
     ma.loadProperties();
     //这个类主要是设置邮件
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.163.com");
     mailInfo.setMailServerPort("25");
     mailInfo.setValidate(true);
     mailInfo.setUserName(servermail);
     mailInfo.setPassword(serverpsd);
     mailInfo.setFromAddress("dongfeng192@163.com");
     mailInfo.setToAddress(new String[]{"2050588049@qq.com"});
     mailInfo.setSubject("发送内容测试");//设置主题
     mailInfo.setContent("这是一份测试内容，由"+servermail+"发送");//设置发送内容
     //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
     sms.sendTextMail(mailInfo);//发送文体格式    
     String str = "";
     String[] ns = str.split(",");
     System.out.println(ns.length);
   }  
}
