package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	
	@Override
	public List<JikwonDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		
		List<JikwonDto> list = null;
		
		try {
			//문제1 (직원번호 직원이름 부서번호 입사일)
			System.out.println("전체 자료 읽기 (JPQL 사용)------");

			list = findAll(em, JikwonDto.class);
			for(JikwonDto mdto : list) {
				System.out.println(mdto.getJikwon_no()+ " " +
						mdto.getJikwon_name() + " "
						+ mdto.getBuser_num()+" "+
						mdto.getJikwon_ibsail());
			}
			
			list = em.createQuery("select e from JikwonDto as e", JikwonDto.class).getResultList();
		
			
			// 문제2 ( 부서명 인원수) 
			String jpql="select e.buser_num, count(e) from JikwonDto e group by e.buser_num";
			List<Object[]> results = em.createQuery(jpql).getResultList();
			
			// 결과 읽기
			for(Object[] result: results) {
				Integer buserNum = (Integer)result[0];
				Long count = (Long)result[1];
				
				System.out.println("부서 번호 : " + buserNum + ", 직원수 : " + count);
			}
	
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : " + e);
		}finally {
			em.close();
			emf.close();
		}

		return list;
	}
		
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		
		return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();
	}
	
	
}
