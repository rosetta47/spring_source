package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter{
	//MessageInter 타입의 파생 클래스 중 하나로 MessageImpl를 작성
	private String message1, message2; // constructor injection을 사용해서 값을 집어넣을 거임
	private int year;
	private MyInfoInter infoInter; 
	//다형성을 쓰는이유 : 하나의 객체가 여러 가지 타입을 가질 수 있는 것
	//부모 클래스 타입의 참조 변수로,  자식 클래스 타입의 인스턴스를 참조할 수 있는 것
	
	private String spec; // setter injection을 사용해서 값을 집어넣을 거임
	private OutFileInter fileInter;
	
	public MessageImpl(String message1, String message2, 
			int year, MyInfoInter infoInter) { //생성자
		this.message1 = message1;
		this.message2 = message2;
		this.year = year;
		this.infoInter = infoInter;
	}
	
	public void setSpec(String spec) {//setter 만듬
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	
	@Override
	public void sayHi() {
		String msg = "MessageImpl 클래스에서 sayHi 내용 : ";
		msg += "\n" + message1 + " " + message2;
		msg += "\n" + (year + 2000) + "년";
		msg += "\n" + infoInter.myData();
		msg += "\n" + spec;

		System.out.println(msg); //console로 출력
		
		//위 메시지를 파일로 출력하기
		fileInter.outFile(msg);
	}
}
