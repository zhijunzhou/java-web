package net.msyy.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

public class LogAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("This is a log create in" + (new Date()) + ";");
		System.out.println("the called method name is " + arg0.getName() + ";");
		System.out.println("and there are some parameter " + (Arrays.toString(arg1)) + ";");
	}

}
