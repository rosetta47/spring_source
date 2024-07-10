package pack;




import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="jikwon")
public class Jikwon {
	@Id
	@Column(name="jikwon_no")
	private int jikwonNo;
	
	@Column(name="jikwon_name")
	private String jikwonName;
	
	@ManyToOne // 테이블 조인할 때 사용
	@JoinColumn(name="buser_num", referencedColumnName = "buser_no")
	private Buser buser;
	
	@Column(name="jikwon_ibsail")
	private Date jikwonIbsail;
	
}
