package anno2_resource;

import org.springframework.stereotype.Component;

@Component("aaa")
public class Abc2 { //POJO라고 불림(단순)
	//POJO는 DTO와 같이 기본적인 자바의 기능인 getter, setter 기능만 가지고 있습니다. 
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
	
	
}
