package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// (이것(EntityManager)을 만드려면 위에 팩토리(EntityManagerFactory)를 만들어야 되)
		EntityManager em = emf.createEntityManager(); //EntityManager : 엔티티의 생명주기를 관리 , CRUD를 수행
		EntityTransaction tx = em.getTransaction(); //Transaction을 관리하는 인터페이스
		
		List<MemDto> list = null;
		
		System.out.println("전체 자료 읽기 ------");

		list = findAll(em, MemDto.class);
		for(MemDto m : list) {
			System.out.println(m.getNum()+ " " + m.getName() + " "
					+ m.getAddr());
		}
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		// JPQL 쿼리임 (sql아니고)
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}
}
