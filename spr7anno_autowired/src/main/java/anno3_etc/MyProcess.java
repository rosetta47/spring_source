package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	//value는 매핑이 아니라 값을 그냥 주는거임, 변수에 값을 초기화하기 위해 사용할 수 도 있다.
	// Spring EL: #{표현식}, 만들어진 컴포넌트 객체를 이용
//	SpEL 표현식은 # 기호로 시작하며 중괄호로 묶어서 표현합니다. #{Expressions}
//	속성 값을 참조할 땐 $ 기호와 중괄호로 묶어서 표현합니다. ${prop.name}
//	ex) #{${prop} + 2}
	@Value("#{dataInfo.name}") 
	private String name;
	
	private String part;
		
	@Autowired //생성자를 통해서 영어부가 들어가는 거임
	//public MyProcess(@Value("영업부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {
		this.part = part;
	}
	
	@Value("123") // 기본이 String type
	private int age;
	
	@Value("1,2,3,4")
	private int arr[]; //배열의 초기치를 줌
	
	public void showData() {	//출력
		System.out.println("name: "+ name);
		System.out.println("part: "+ part);
		System.out.println("age: "+ age);
		System.out.println(arr[0] + " " + arr[3]);
	}
}
