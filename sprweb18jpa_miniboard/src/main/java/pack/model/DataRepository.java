package pack.model;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<Board, Integer>{
	//JPQL
	//검색용 만들어야 함(따로 2개)
	@Query("select b from Board as b where b.author like %?1%") //like 위치에 대한 매핑
	List<Board> searchLike(String searchValue); //작성자별
	
	@Query("select b from Board as b where b.title like %:searchValue%") //like 이름
	List<Board> searchLike2(@Param("searchValue") String searchValue); //글 제목별
	
	// 추가할 때 가장 큰 번호 얻기
	@Query("select max(b.num) from Board b")
	int maxNum();
	
	// 상세보기 할 때 조회수 증가
	// 벌크연산 = update, delete, insert 에 사용
	// 내부적으로 JPA는 벌크연산(Bulk Operation : 대량의 데이터를 수행하기 위해서)을 한다. 영속성 컨텍스트에 있는 자료(Board)와 DB에 있는 자료(Board)값이 다를 수 있다.
	//벌크 연산 수행 후 영속성 컨텍스트에 있는 쿼리를 refresh(clear)해야 한다.
	@Modifying(clearAutomatically = true) //1차 캐시를 비워주는 설정.영속성 컨텍스트에 있는 쿼리를 초기화한다.
	@Query(value = "update Board as bo set bo.readcnt=bo.readcnt+1 where bo.num=?1")
	void updateReadcnt(int num);
	
	
}
