package pack;

import org.springframework.stereotype.Repository;

@Repository
public class DataDaoImpl implements DataDao{
	@Override
	public void selectData() {
		System.out.println("db  연동 후 자료 읽기 처리함");
		
	}
}
