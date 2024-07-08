package pack.business;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model를 포함 관계로 호출
	@Autowired
	private JikwonInter jikwonInter;

	@Override
	public void jikwonList() {
		System.out.println("고객 번호 : ");
		Scanner sc = new Scanner(System.in);
		String gogekNum = sc.nextLine();
		System.out.println("고객 이름 : ");
		sc.close();

		int count = 0;
		for (JikwonDto j : jikwonInter.selectList(gogekNum)) {
			System.out.println(j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_name() + " "
					+ j.getBuser_tel() + " " + j.getJikwon_jik());
			count++;
		}

		System.out.println("인원 수 : " + count);

	}

}
