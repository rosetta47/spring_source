package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class OurAdvice { // Aspect 클래스 : Advice용
	 // 무조건 Object로 해야되
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		
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
