package pack;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.JikwonDto;
import pack.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model를 포함 관계로 호출
	@Autowired
	private JikwonInter jikwonInter;

	@Override
	public void jikwonList() {
		System.out.println("고객번호 : ");
		Scanner sc = new Scanner(System.in);
		String gogekNum = sc.nextLine();
		System.out.println("고객이름 :");
		String name = sc.nextLine();
		sc.close();

		
		List<JikwonDto> list = jikwonInter.selectList(gogekNum, name);
		if(list.isEmpty()) {
			System.out.println("로그인 실패");
			System.exit(0);
		}

		for(JikwonDto j:list) {
			System.out.println(j.getJikwon_name() + " " + 
							j.getJikwon_jik() + " "+
							j.getJikwon_gen());
			
		}
	}

}
