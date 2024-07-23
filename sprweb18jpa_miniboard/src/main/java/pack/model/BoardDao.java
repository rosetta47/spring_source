package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataRepository dataRepository;
	
	public List<Board> list(){// 전체 자료 읽기
		List<Board> list = dataRepository.findAll();
		logger.info("list size : " + list.size());
		
		return list;
	}
	
	// 검색자료 search
	public List<Board> search(BoardBean bean){// 검색 자료 읽기
		List<Board> slist = null;
		
		if(bean.getSearchName().equals("author")) {
			slist = dataRepository.searchLike(bean.getSearchValue());
		}else {
			slist = dataRepository.searchLike2(bean.getSearchValue());
		}
		return slist;
	}
	
	@Transactional  // 프록시 객체는 해당 메소드가 처리될 때 Commit or Rollback을 수행
	// CheckedException 또는 예외가 없는 경우 커밋을 수행
	// UncheckedException가 발생하면 롤백을 수행
	public String insertData(BoardBean bean) {
		try {
			// 새글 입력시 가장 큰 번호를 얻어 +1
			int max = dataRepository.maxNum();
			
			Board dto = new Board();
			dto.setNum(max + 1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			
			dataRepository.save(dto);
			
			return "success";
		} catch (Exception e) {
			return "입력 오류 : " + e.getMessage();
		}
	}
	
	// detail
	@Transactional //select 빼고 다 걸어줘
	public Board detail(int num) {
		// 조회수 증가
		dataRepository.updateReadcnt(num);
		
		//Optional 클래스란?
		//Java 8에서 추가된 기능으로 값이 존재하지 않는 경우(Null)를 다루는 데 사용된다. 
		//이 클래스는 값이 있을 수도 있고 없을 수도 있는 상황을 나타내는 컨테이너 역할을 하며, 
		//NullPointerException과 같은 예외를 방지한다.
		
		// Repository에서 findById()의 반환값은 Optional 타입
		Optional<Board> board = dataRepository.findById(num);
		logger.info("board :: {}", board.get());
		
		if(board.isPresent()) {// 값이 있어 : isPresent()
			return board.get();
		}else {
			return new Board();
		}
	}
	
	// update
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			// 조회수도 수정에 참여하기 위한 작업이 필요함(선행작업)
			Optional<Board> board = dataRepository.findById(bean.getNum());
			Board imsi = board.get(); // Optional를 쓰면 get()으로 받아야되
			
			/*
			Board dto = new Board();
			dto.setNum(bean.getNum()); // 이미 등록된 num 이므로 수정
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setReadcnt(imsi.getReadcnt());
			
			dataRepository.save(dto);
			
			*/
			
			// save 안쓰고 하는 법
			imsi.setAuthor(bean.getAuthor());
			imsi.setTitle(bean.getTitle());
			imsi.setContent(bean.getContent());
			imsi.setReadcnt(imsi.getReadcnt());
			
			return "success";
		} catch (Exception e) {
			return "수정 오류 : " + e.getMessage();
		}
	}
	
	//delete
	@Transactional
	public String deleteData(int num) {
		try {
			dataRepository.deleteById(num);
			
			return "success";
		} catch (Exception e) {
			return "삭제 오류 : " + e.getMessage();
		}
	}
}
