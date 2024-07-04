package pack.controller;

import java.util.Scanner;
import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter;
	private String rs[];
	
	//set를 생성함
	public void setInter(SangpumInter inter) {
		this.inter = inter;
	}

	public MyImpl() {
		//아규먼트 없는 생성자
	}
	
	@Override
	public void inputData() {
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("상품 입력 : ");
			String sang = scanner.next();
			System.out.println("수량 입력 : ");
			int su = scanner.nextInt();
			System.out.println("단가 입력 : ");
			int dan = scanner.nextInt();
			rs = inter.calcMoney(sang, su, dan);
			 		
		} catch (Exception e) {
			System.out.println("inputData err : "  + e.getMessage());
		}
	}
	
	@Override
	public void showData() {
	System.out.println("상품명: " + rs[0] + "\n" + "금액은: " +  rs[1] + "원");
		
	}
}
