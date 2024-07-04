package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 참고 : 계층(Layers)별 어노테이션 구분
// Appliacation layer : 클라이언트와 데이터 입출력을 제어 @ Controller...
// Domain layer : 어플리케이션 중심이며, 업무처리를 담당 @ Service ...
// Infrastuctor layer : DB에 대한 영속성, 지속성, (persistance) 등을 담당 @ Repository ...

//@Component
@Service
//@Service("senderProcess")
//@Scope("singleton")
public class SenderProcess {
	//@Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션. (name에 의한 매핑이 아니라  type 으로 매핑) 중요!!!
	
	@Autowired // field injection : 간단하나 테스트가 불편함, 주로 많이 사용
	private Sender sender; //Sender.java에서 @을 함으로 써 주소값이 이리고 들어옴
	
	/*
	@Autowired // setter injection : set를 계속 써야되기 때문에 코드가 장황해짐
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired // Constructor injection : 불변성과 테스트가 편하지만 생성자가 너무 많아진다는 단점이 있다.
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
	public Sender getSender() {
		return sender;
	}
	
	public void dispData() {
		sender.show();
	}
}
