package pack.controller;

import lombok.Data;
import pack.model.Jikwon;

@Data
public class JikwonBean {
	private int jikwon_no;
	private String jikwon_name,jikwon_jik,jikwon_pay,jikwon_rating;
	private String searchName,searchValue;
}
