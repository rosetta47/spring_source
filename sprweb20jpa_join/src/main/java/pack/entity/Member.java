package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.dto.MemberDto;

@Getter
@Setter
@Builder // builder사용할때는 @Data 사용하지말고 @Getter,@Setter 사용해
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEMBER_TBL")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // num 자동 증가
	private Long num;
	private String name;
	private String addr;
	
	//dto를 entity로 변환하기
	public static Member toEntity(MemberDto dto) {
		
		return Member.builder()
				.num(dto.getNum())
				.name(dto.getName())
				.addr(dto.getAddr())
				.build();
	}
	
	
}
