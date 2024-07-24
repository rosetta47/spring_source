package pack.service;

import org.springframework.ui.Model;

import pack.dto.MemberDto;

public interface MemberService {
	public void getList(Model model);//회원 자료 전체를 읽기
	public void insert(MemberDto dto); 
	public void getData(Long num, Model model);
	public void update(MemberDto dto);
	public void update2(MemberDto dto);
	public void delete(Long num); //num을 가지고 삭제
	
	
}
