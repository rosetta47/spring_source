package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friend {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY); // 반호 칼럼이 auto_increment일 때 씀
	private int bunho;
	private String irum;
	private String junhwa;
	private String jikup;
	
	@Lob //BLOB, CLOB 타입일때 사용
	private byte[] sajin;
	private String imagetype;
	
	//임시 칼럼이 필요 (테이블에 없는)
	@Transient //DB와 관련없는 임시 데이터 저장용
	private String base64Image; //base64로 인코딩된 이미지 타입
	
}
