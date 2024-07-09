package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="mem") // DB의 특정 테이블과 매핑
public class MemDto { // 카멜케이스로 작성하면 자동으로 언더스코어 네이밍 컨벤션을 따른다.
	@Id
	@Column(name="num")
	private int num;
	
	@Column(name="name", nullable = true) //null을 허용하고 있다
	private String name;
	
	private String addr;
	
	
	
}
