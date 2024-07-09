package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select(sql)
	public List<JikwonDto> selectDataAll();
	String sql="SELECT jikwon_no, jikwon_name, buser_name, jikwon_ibsail FROM jikwon inner JOIN buser ON buser.buser_no = jikwon.buser_num";
	
	@Select(sql2)
	public List<JikwonDto> selectBuser();
	String sql2="SELECT buser_name, COUNT(buser_name) as su FROM buser INNER JOIN jikwon ON jikwon.buser_num=buser.buser_no GROUP BY buser_name";
	
	@Select(sql3)
	public List<JikwonPayDto> selectMaxpay();
	String sql3="SELECT buser_name, jikwon_name, jikwon_pay as maxpay FROM jikwon INNER JOIN buser ON jikwon.buser_num = buser.buser_no WHERE jikwon_pay  IN (SELECT MAX(jikwon_pay) FROM jikwon WHERE buser_num = buser_no GROUP BY buser_num) ORDER BY buser_name;";
	
}
