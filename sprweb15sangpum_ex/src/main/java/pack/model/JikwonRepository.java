package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	// 검색을 하기 위한 것
	//List<Jikwon> findByJikwon_jikcontaining(String svalue); // 검색어가 포함된 추상메소드 : like '%검색어%'

	// JPQL 사용하기 싶어 그럼 //
	@Query(value = "select s from Jikwon as s where s.jikwonJik like %:svalue%")//이름에 대해 매핑하면 아래 파람만들어
	List<Jikwon> searchLike(@Param("svalue") String svalue);
}
