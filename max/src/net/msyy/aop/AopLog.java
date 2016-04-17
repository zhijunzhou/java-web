package net.msyy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopLog {

		public Object runOnAround(ProceedingJoinPoint point) throws Throwable{
			System.out.println("begin around");
			Object object = point.proceed();
			System.out.println("end around");
			return object;
		}
}
