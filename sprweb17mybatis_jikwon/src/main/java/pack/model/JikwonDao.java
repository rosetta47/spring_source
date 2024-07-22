package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.JikwonBean;


@Repository
public class JikwonDao {
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapInterface mapInterface;
	
	// 전체 자료 읽기
		public List<Jikwon> list(){
			List<Jikwon> list = null;
			try {
				list = mapInterface.selectList();
			} catch (Exception e) {
				logger.info("list err: " + e);
			}
			return list;
		}
		// 검색용
		public List<Jikwon> search(JikwonBean bean){
			List<Jikwon> slist = mapInterface.selectSearch(bean);
			return slist;
		}
	
}
