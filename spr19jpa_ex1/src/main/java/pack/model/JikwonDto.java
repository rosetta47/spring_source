package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity 
@Table(name="jikwon")	
public class JikwonDto {
	@Id
	@Column(name="jikwon_no")
	private int jikwon_no;
	
	@Column(name="jikwon_name") //null을 허용하고 있다
	private String jikwon_name;
	
	private int buser_num;
	private String jikwon_ibsail;
	
	
}
