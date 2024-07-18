package pack;

import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer>{ //code(pk)가 Integer라서 이걸줌
	// save(), findById(), count(), ... 지원 받음
	
}
