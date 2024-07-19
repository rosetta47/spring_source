package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private SangpumRepository repository;
	
	// 전체 자료 읽기
	public List<Sangpum> getDataAll(){
		List<Sangpum> list = repository.findAll(); // 기본 메소드
		return list;
	}
	
	// 검색 자료 읽기
	public List<Sangpum> getDataSearch(String svalue){//뭐가 넘어와? svalue라고 걸어둠
		//List<Sangpum> list = repository.findBySangContaining(svalue); // 네이밍 룰(방법1)
		List<Sangpum> list = repository.searchLike(svalue); //jpql를 함(방법2)
		System.out.println("list : " + list.size());
		return list;
		
	}
	
}
