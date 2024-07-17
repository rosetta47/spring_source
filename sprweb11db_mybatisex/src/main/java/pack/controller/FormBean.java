package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormBean {
	private String jikwon_no, jikwon_name, jikwon_gen, jikwon_pay; // 추가, 수정 시 필요해
	private String searchValue; // 검색용 변수
}
