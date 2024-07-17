package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;


@Mapper
public interface DataMappingInterface {
	@Select("select * from jikwon")
	List<JikwonDto> selectAll();
	
	@Select("select jikwon_no, jikwon_name, jikwon_gen, jikwon_pay from jikwon"
			+ " where jikwon_jik = #{jikwon_jik}")
	List<JikwonDto> selectSearch(FormBean bean); 

}
