package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args)
		.getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crudRepository;
	
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		
		insData();
		delData(); 
		selectData();
		
		class1.abc();
		
	}
	// 추가 , 업데이트
	private void insData() {
		//ProductVo productVo = new ProductVo();
		//productVo.setCode(4);
		//ProductVo productVo = new ProductVo(null,"볼펜", 2, 1000); // 번호에 값을 안주면 insert
		ProductVo productVo = new ProductVo(2,"사랑비", 10, 2000); //번호에 값을 주면 update
		//System.out.println(productVo.toString());
		crudRepository.save(productVo);// save하니까 볼펜이 추가됨.(번호를 null로 주면 추가고 있는 번호에 값을 주면 udpate)
	}
	
	
	// 삭제
	private void delData() {
		crudRepository.deleteById(3); // 어떤걸 지울래? 3번을 지울꺼야
		
	}
	
	
	// 자료 읽기(전체 레코드 읽기)
	// JPA를 쓰는 이유 : 다른 오라클이나 써도 코드를 수정할 필요가 없어서 좋아
	private void selectData() {//.findAll() = select * from product;를 알아서 한거야
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll();
		//System.out.println(list.get(0).getSang());//우산
		for(ProductVo p:list) {
			System.out.println(p.getCode()+ " " +
					p.getSang()+ " " +
					p.getSu()+ " " +
					p.getDan());
		}
		
		System.out.println();
		// 1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();//2 우비 7 15000 만 읽혔다.
		System.out.println(vo.getCode()+ " " +
				vo.getSang()+ " " +
				vo.getSu()+ " " +
				vo.getDan());
	}
}
