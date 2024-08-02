package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemberDto;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession session;

	// 회원자료 전체 읽기
	public List<MemberDto> getList() {
		return session.selectList("member.getList");
	}

	// insert
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto); // Mapper에서 member에 insert
	}

	// 수정 삭제 자료 읽기
	public MemberDto getData(int num) {
		return session.selectOne("member.getData", num);
	}

	// update
	public void update(MemberDto dto) {
		session.insert("member.update", dto); // Mapper에서 member에 insert
	}

	// delete
	public void delete(int num) {
		session.insert("member.delete", num); // Mapper에서 member에 insert
	}
}
