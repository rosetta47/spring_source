package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.ShinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	//@Autowired와 마찬가지로 Bean 객체를 주입해주는데 차이점은 Autowired는 타입으로, 
	//Resource는 이름으로 연결해준다.
	
	@Autowired(required = true) // type으로 연결
	private ShinhanBank shinhanBank;
	
	@Resource(name="hanaBank") // name으로 연결
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("shinhan")) {
			bank = shinhanBank;
		}else if(sel.equals("hana")){
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int money) {
		bank.inputMoney(money); //입금
	}
	
	public void playOutputMoney(int money) {
		bank.outputMoney(money); //출금
	}
	
	private String msg;
	
	@PostConstruct // 생성자 후에 바로 부름(생성자 처리 후 자동 호출) : 초기화 작업 가능
	public void abc() {
		msg = "계좌 잔고 : ";
	}
	
	@PreDestroy // web 서비스 종료 직전 자동 호출 : 마무리 작업을 가능
	//객체를 제거하기 전(pre)에 해야할 작업을 수행하기 위해 사용한다.
	public void def() {
		if(shinhanBank != null) shinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	
	public void showMoney() {
		//System.out.println("계좌 잔고 : " + bank.getMoney());
		System.out.println(msg + bank.getMoney());
	}
}
