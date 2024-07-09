package pack.model;

import java.util.List;

public interface JikwonInter {
	List<JikwonDto> selectDataAll(); // 직원자료
	List<JikwonDto> selectBuser(); // 부서별 인원수
	List<JikwonPayDto> selectMaxpay(); // 부서별 최대 급여자
}
