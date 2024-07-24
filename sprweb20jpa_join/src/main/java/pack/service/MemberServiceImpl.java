package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memRepository;
	
	@Override
	public void getList(Model model) {
		/*
		//방법1 :  멤버 전체 자료를 반환 : 기본 메소드(findAll()) 사용
		// Member 엔티티를 MemberDto 객체로 전달
		List<Member> entityList = memRepository.findAll();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		for(Member temp:entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		*/
		
		// 방법2 : List<Member>를 Stream으로 변경해서 map()을 사용 List<MemberDto>로 변경하기
		List<MemberDto> list = memRepository
								.findAllByOrderByNumDesc()
								.stream()
								.map(item -> MemberDto.toDto(item)).toList();
		
		/*
		// 방법3 : 람다 표현식을 메소드 참조 표현식으로 기술한거  ex)클래스명::메소드명
		List<MemberDto> list2 = memRepository
								.findAllByOrderByNumDesc()
								.stream()
								.map(MemberDto::toDto).toList();
		*/
		
		
		model.addAttribute("list",list); // 컨트롤러에 MemberDto가 담긴 list를 전달함
	}
	
	@Override
	public void insert(MemberDto dto) {
		// Jpa 작업 영역 내로 들어갈때 일반 자료 전달용 객체 (dto, formbean) 객체를 대응 엔티티로 변환
		memRepository.save(Member.toEntity(dto));
		
	}
	
	// 수정 자료 읽기
	@Override
	public void getData(Long num, Model model) {
		//Model 객체는 스프링이 제공하는 모델을 사용하는 것이므로 따로 반환을 해주지 않아도 된다.
		Member m = memRepository.findById(num).get();
		
		model.addAttribute("dto", MemberDto.toDto(m)); 
		//Member를 MemberDto의 toDto에 넣어
	}
	
	// update 이리로 와 (controller -> service)
	@Override
	public void update(MemberDto dto) {
		memRepository.save(Member.toEntity(dto));
		
	}
	
	@Override
	public void update2(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Long num) {
		memRepository.deleteById(num);
		
	}
	
}
