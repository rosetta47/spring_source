package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class ProductVo {
	@Id
	@Column(name="code")
	//@GeneratedValue 어노테이션을 사용하면 식별자 값을 자동 생성 시켜줄 수 있다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(name="sang", nullable = true, length = 20)
	private String sang;
	
	private int su;
	private int dan;
}
