package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// LogicImpl 클래스는 LogicInter 인터페이스를 구현합니다.
public class LogicImpl implements LogicInter{
	
	@Autowired
    // ArticleInter 인터페이스를 참조하는 private 멤버 변수 articleInter를 선언합니다.
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}


	// LogicInter 인터페이스의 selectDataProcess1 메서드를 구현합니다.
	@Override
	public void selectDataProcess1() {
		// "selectDataProcess1 수행"이라는 메시지를 콘솔에 출력합니다.
		System.out.println("selectDataProcess1 수행");
		// articleInter의 selectAll 메서드를 호출합니다.
		articleInter.selectAll(); // 모델 클래스 수행 결과가 출력됨
		
		System.out.println("-----------------");
	}
	
	// LogicInter 인터페이스의 selectDataProcess2 메서드를 구현합니다.
	@Override
	public void selectDataProcess2() {
		// "selectDataProcess2 처리"라는 메시지를 콘솔에 출력합니다.
		System.out.println("selectDataProcess2 처리");
		// articleInter의 selectAll 메서드를 호출합니다.
		articleInter.selectAll(); 
		// 타임 지체를 위해 3초 동안 대기합니다.
		try {
			// 3초 동안 현재 스레드를 잠재웁니다.
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception (예외 처리 코드가 필요합니다)
		}
		// "3초 지연 처리"라는 메시지를 콘솔에 출력합니다.
		System.out.println("3초 지연 처리");
	}
}
