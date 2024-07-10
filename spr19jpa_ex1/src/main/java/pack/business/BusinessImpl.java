package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.JikwonDto;


@Service
public class BusinessImpl implements BusinessInter{
	
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataPrint() {
		List<JikwonDto> mlist = dataInterface.selectDataAll();
		
		System.out.println("dataPrint 메소드에서 출력");
		for(JikwonDto m : mlist) {
			System.out.println(m.getJikwon_no()+ " " + m.getJikwon_name() + " "
					+ m.getBuser_num()+ " " + m.getJikwon_ibsail());
		}
		
	}

}
