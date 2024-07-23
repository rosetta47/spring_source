package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	
	List<Jikwon> findByBuserNum(int buserNum); // rule에 따라서 함 쿼리문 필요없어
	
	List<Jikwon> findByBuserNumAndJikwonRating(int buserNum, String rating);

}
