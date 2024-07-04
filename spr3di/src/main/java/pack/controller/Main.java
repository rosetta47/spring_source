package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		
		//다형성
		MyInter myInter = (MyInter)context.getBean("myProcess"); //캐스팅해야됨!
		myInter.inputMoney();
		myInter.showResult();

	}

}
