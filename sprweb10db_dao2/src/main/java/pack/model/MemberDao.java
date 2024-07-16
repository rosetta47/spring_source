package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport{

	@Autowired
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	// 전체 자료 읽기
	public List<MemberDto> getMemberList(){
		String sql = "select * from membertab";
		
		/*
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override //무명클래스로 만들어 사용함
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
		*/
		
		// 람다 표현식 사용
		List<MemberDto> list = getJdbcTemplate().query(sql,(ResultSet rs, int rowNum) ->{
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
				
		return list;
	}
	
	// 자료 추가
	public void insData(MemberBean bean) {
		String sql = "insert into membertab values(?,?,?,now())";
		// 넘길때는 무조건 Object[] 배열로 넘겨야되 (위에 String bean 하나만 넘겨도 배열로 넘겨)
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()};
		getJdbcTemplate().update(sql, params);
	}
	
	// 수정
	
	// 삭제
}
