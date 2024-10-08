package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pack.controller.FormBean;

@Repository
@Slf4j // 로그를 출력하는데 롬복이 지원함
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());//this.getClass() : 현재클래스
	@Autowired
	private DataMappingInterface mappingInterface;
	
	public List<JikwonDto> getDataAll(){
		List<JikwonDto> list = mappingInterface.selectAll();
		
		return list;
		
	}
	
	// 검색용이야
	public List<JikwonDto> getDataSearch(FormBean bean){
		List<JikwonDto> slist = mappingInterface.selectSearch(bean);
		return slist;
		
	}
}
