package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.JikwonBean;

@Mapper
public interface DataMapInterface {
	// 추상메소드명은 mapper.xml의 id명과 일치시킨다.
		List<Jikwon> selectList();
		List<Jikwon> selectSearch(JikwonBean bean);
	//	Jikwon selectOne(String num);
}
