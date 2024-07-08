package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class OurAdvice { // Aspect 클래스 : Advice용
	@Around("execution(* *..*LogicInter*.*(..)) or execution(public void selectAll())")
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		// 무조건 Object로 해야되
		// 수행 시간 체크
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("핵심 메소드 수행 전 관심사항 실행(ex.로그인,보안)");
		
		Object object = joinPoint.proceed(); // 선택된 핵심 메소드 수행
		
		System.out.println("핵심 메소드 수행 후 뭔가를 처리");
		
		stopWatch.stop();
		System.out.println("처리 시간 : " + stopWatch.getTotalTimeSeconds());
		return object;
	}
	
	
}
