package controller;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 

import model.DataDao; 
import model.DataDaoImpl; 

public class ServiceMain { 

	public static void main(String[] args) { 
		// 전통적인 방법 (Spring 프레임워크를 사용하지 않음)
		// DB 처리 객체 생성함
		DataDaoImpl impl = new DataDaoImpl(); // DataDaoImpl 클래스의 인스턴스를 생성
		DataDao dataDao = impl; // DataDao 타입의 변수에 impl 객체를 할당하여 다형성을 활용
		
		// BL (Business Logic) 관련 객체를 생성함
		ProcessServiceImpl serviceImpl = new ProcessServiceImpl(dataDao); // ProcessServiceImpl 클래스의 인스턴스를 생성하며, 생성자에 dataDao를 주입
		ProcessService processService = serviceImpl; // ProcessService 타입의 변수에 serviceImpl 객체를 할당하여 다형성을 활용
		processService.selectProcess(); // processService 객체의 selectProcess 메서드를 호출
		
		System.out.println("-----------"); // 구분선을 출력
		
		// spring 방법 (Spring 프레임워크를 사용하는 방법)
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("init.xml"); // Spring의 ApplicationContext를 사용하여 init.xml 파일에서 빈 설정을 로드
		
		ProcessService processService2 = 
				(ProcessService)context.getBean("serviceImpl"); // Spring 컨테이너에서 'serviceImpl'이라는 이름의 빈을 가져와 ProcessService 타입으로 형 변환
		processService2.selectProcess(); // processService2 객체의 selectProcess 메서드를 호출
	}
}
