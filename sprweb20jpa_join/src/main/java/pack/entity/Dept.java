package pack.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LazyInitializationException;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dept {
	@Id
	private int deptno; // 공통칼럼
	private String dname; // deptname
	private String loc; // location
	
	//fetch join 사용할꺼임
	//FetchType.LAZY : Dept 사용중 Emp는 필요할때 천천히 로딩됨(지연 로딩)
	//세션이 열려 있는 동안 세션관리가 필요하며 LazyInitializationException이 발생하는 것을 조심해야되(조치필요)
	//FetchType.EAGER : Dept 사용중 Emp는 필요할때 즉시 로딩됨
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	@Builder.Default // Emp 엔티티가 생성될 때 list를 초기화함 
	//여기서 빌더 패턴을 통해 인스턴스를 만들 때 특정 필드를 특정 값으로 초기화하고 싶다면 @Builder.Default를 쓰면 된다.
	private List<Emp> list = new ArrayList<Emp>();
	
}
