package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;
import pack.model.JikwonPayDto;


@Service
public class BusinessImpl implements BusinessInter{
	// model 클래스를 호출
	
	@Autowired
	private JikwonInter inter;
	
	public BusinessImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void dataPrint() {
		List<JikwonDto> list = inter.selectDataAll();
		
		for(JikwonDto s:list) {
			System.out.println(s.getJikwon_no() + " " +
					s.getJikwon_name() + " " +
					s.getBuser_name() + " " +
					s.getJikwon_ibsail());
		}
		
	}
	@Override
	public void dataCount() {
		List<JikwonDto> list = inter.selectBuser();
		
		for(JikwonDto sb:list) {
			System.out.println(sb.getBuser_name() + " " + sb.getSu());
			
		}
	
	}
	@Override
	public void dataMaxpay() {
		List<JikwonPayDto> plist = inter.selectMaxpay();
		
		for(JikwonPayDto p:plist) {
			System.out.println(p.getBuser_name()+ " "+p.getJikwon_name()+" "+ p.getMaxpay());
		}
		
	}
	
}
