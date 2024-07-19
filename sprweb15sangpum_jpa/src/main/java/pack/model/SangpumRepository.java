package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SangpumRepository extends JpaRepository<Sangpum, Integer>{
	// 메소드 네이밍 규칙 : findBy[엔티티명]칼럼명..., readBy[엔티티명]칼럼명..., getBy[엔티티명]칼럼명...,
	// findBy변수명And변수명, findBy변수명Or변수명, findBy변수명 GreaterThanEqual... 등 쓰는 규칙이다.
	
	// 검색을 하기 위한 것
	List<Sangpum> findBySangContaining(String svalue); // 검색어가 포함된 추상메소드 : like '%검색어%'
	List<Sangpum> findBySangStartingWith(String svalue);// 검색어로 시작되는 추상메소드 : like '검색어%'
	List<Sangpum> findBySangEndingWith(String svalue);// 검색어로 끝나는 추상메소드 : like '%검색어'
	
	
	// JPQL 사용하기 싶어 그럼
	@Query(value = "select s from Sangpum as s where s.sang like %:svalue%")//이름에 대해 매핑하면 아래 파람만들어
	List<Sangpum> searchLike(@Param("svalue") String svalue);
}
