package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selectBank("shinhan");
		daniel.playInputMoney(500);//5500
		daniel.playOutputMoney(200);//5300
		System.out.print("daniel = ");
		daniel.showMoney();
		
		Gogek john = (Gogek)context.getBean("gogek");
		john.selectBank("shinhan");
		john.playInputMoney(500);//5500
		john.playOutputMoney(200);//5300이 나와야 되는데 5600이 나옴(why? 다니엘과 연결이 됨 5300+500-300)
		System.out.print("john = ");
		john.showMoney();

		Gogek oscar = (Gogek)context.getBean("gogek");
		oscar.selectBank("hana");
		oscar.playInputMoney(500);//1500
		oscar.playOutputMoney(100);//1400
		System.out.print("oscar = ");
		oscar.showMoney();
		
		//3개의 주소가 같다 싱글톤이기 때문에 
		System.out.println("daniel 객체 주소: " + daniel);//pack.gogek.Gogek@446a1e84
		System.out.println("john 객체 주소 : " + john);//pack.gogek.Gogek@446a1e84
		System.out.println("oscar 객체 주소 : " + oscar);//pack.gogek.Gogek@446a1e84
		
		// 하지만 @Scope("prototype")를 하면 각각의 주소가 생긴다
	}

}
