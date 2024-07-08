package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository 
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter{
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct // 생성자 다음에 수행되는 것임
	public void abcd() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<JikwonDto> selectList(String gogekNum, String name) throws DataAccessException {
		RowMapper rowMapper = new JikwonMapper();
		String sql = "select jikwon_name, jikwon_jik, jikwon_gen"
				+ " from jikwon INNER JOIN gogek ON jikwon.jikwon_no = gogek.gogek_damsano where gogek_no=" + gogekNum +" and gogek_name="+
				 "'" +  name + "'";

		return (List)getJdbcTemplate().query(sql, rowMapper);
	}
	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			JikwonDto dto = new JikwonDto();
			dto.setJikwon_name(rs.getString("jikwon_name"));
			dto.setJikwon_jik(rs.getString("jikwon_jik"));
			dto.setJikwon_gen(rs.getString("jikwon_gen"));
			return dto;	
		}
	}
}
