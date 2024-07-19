package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sangdata")// 원본 테이블과 다르면 Table을 걸어준다
//(원본 테이블 이름은 sangdata이지만 난 sangpum으로 만들었으니까 Table를 걸어준다)
public class Sangpum {
	@Id
	private int code;
	
	@Column(nullable = false)
	private String sang;
	
	private int su;
	private int dan;
}
