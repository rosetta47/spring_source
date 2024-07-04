package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:arrange.xml");
		*/
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		
		//클래스로 받음
		System.out.println("Singleton 확인하세요");
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		//주소 찍어봄 // 객체 주소가 같음 = xml에서 값이 싱글톤으로 만들어지고 있다. 
		System.out.println("객체 주소 : " + impl1 + " " + impl2);
		
		//인터페이스로 받음 (이렇게 받는게 더 좋아)
		System.out.println("\n---- 다형성 처리하세요");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		System.out.println("\n---- 다형성 처리하세요2");
		MessageInter inter2 = context.getBean("mImpl",MessageInter.class);
		inter.sayHi();
		
		context.close(); // GenericXmlApplicationContext을 사용하면 close를 사용할 수 있음
		
	}

}
