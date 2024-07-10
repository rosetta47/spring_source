package pack;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="buser")
public class Buser {
	@Id // 테이블 이름이 달라졌다 id 걸어줘
	@Column(name="buser_no")
	private int buserNo;
	
	@Column(name="buser_name")
	private String buserName;
	
}
