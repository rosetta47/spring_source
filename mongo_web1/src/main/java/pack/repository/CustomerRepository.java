package pack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pack.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	// 메소드 선언
	Customer findByName(String name); // JPA 해봐서 익숙하잖아
	
	
}
