package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 Annotation 임
//@Component("sender")
// single pattern으로 Sender 객체가 생성됨(지가 스스로 인스턴스 하는 거임) 객체 변수명은 sender로 알아서 생성
//@Scope("singleton")
public class Sender implements SenderInter{
	public void show() {
		System.out.println("Sender의 show 메소드 수행");
	}
}
