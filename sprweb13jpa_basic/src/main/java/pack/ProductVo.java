package pack;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class ProductVo { //PRODUCT_VO로 만들어짐 위에 테이블을 안주면
	@Id //pk(code)라서 id를 줌
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
	
	
}
