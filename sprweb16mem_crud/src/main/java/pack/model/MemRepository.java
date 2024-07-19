package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer>{
	// num 자동 증가용 // 가장 큰 번호를 갖는다.
	@Query(value = "select max(m.num) from Mem as m")
	//@Query(value = "select max(num) from mem", nativeQuery = true)
	int findByMaxNum();
	
}
