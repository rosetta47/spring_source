package pack.controller;

import java.util.Scanner;
import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter;
	private String rs[];
	
	public MyImpl(SangpumInter inter) {
		this.inter = inter;// 상품inter 하위클래스 모두 쓸 수 있어서 상위클래스를 써야되
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
