package spr12aop_login;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Around("execution(public void startProcess())")
	public Object abc(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("AOP 시작 : 핵심 로직 수행 전 id 검증 먼저");
		
		System.out.println("input id : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		sc.close();
		
		if(!id.equals("ok")) {
			System.out.println("id 불일치! 작업을 종료합니다");
			return null; // 28번줄을 안만남(null을 리턴하면)
		}
		
		Object object = joinPoint.proceed();
		
		return object;
	}
}
