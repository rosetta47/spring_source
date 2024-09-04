package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	// CORS 설정을 관리하기 위해 사용되는 인터페이스
	// 글로벌 CORS 설정은 모든 HTTP 엔드포인트에 대해 적용된다
	//  필요에 따라 특정 경로에 따라 CORS 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*") // 모든 도메인 허용
				.allowedMethods("GET", "POST","PUT","DELETE") // 허용할 HTTP 메소드
				.allowedHeaders("*"); // 모든 헤더 적용
	}
}
