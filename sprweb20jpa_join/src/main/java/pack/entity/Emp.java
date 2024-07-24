package pack.entity;

import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emp {
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr; // 관리자 직원 번호
	@Temporal(TemporalType.DATE) // JPA 에서만 지원 : 날짜 타입 매핑시 사용
	private Date hiredate; // 입사일
	private Double sal;  //월급
	private Double comm;
	//private Integer deptno;// 부서번호
	
	// fetch join
	@ManyToOne(fetch = FetchType.EAGER) //다대일
	@JoinColumn(name = "deptno", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Dept dept;
	
	
	
}
