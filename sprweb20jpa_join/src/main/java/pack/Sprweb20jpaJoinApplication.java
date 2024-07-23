package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class Sprweb20jpaJoinApplication {
	//1) 어플리케이션에서 SQL 처리용 메소드 연습
	//2) 웹(@MVC)에서 회원 자료 처리
	//3) @MVC 에서 직원 자료 처리(이때 조인도 함)
	//4) JPQL 연습용 화면 작성 : Ajax 
	
    @Autowired
	private EntityManagerFactory emf;
	
    // 생성자 이후 자동 실행
	@PostConstruct
	public void initMembers() { // Hibernate 객체를 사용 : dept, emp 샘플 데이터를 JPQL을 이용해 저장하기
		// 자료를 넣을 꺼임
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			List<String> queries = new ArrayList<String>();
			
			queries.add("INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');");
			
			queries.add("INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,TO_DATE('1981-11-17','YYYY-MM-DD'),5000,NULL,10);");
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("err : " + e);
			tx.rollback();
		}finally {
			em.close();
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sprweb20jpaJoinApplication.class, args);
	}

}
