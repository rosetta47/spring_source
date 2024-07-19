package pack.controller;

import lombok.Data;

@Data
public class FormBean {
	private String jikwon_no, jikwon_name, jikwon_gen, jikwon_jik, jikwon_pay;
	
	private String searchValue;
}
