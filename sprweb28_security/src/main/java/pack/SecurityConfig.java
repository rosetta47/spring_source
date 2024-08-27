package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //보안웹 활성화를 위한 것
public class SecurityConfig { // 기본적인 웹 보안 구성을 설정
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//HttpSecurity : 애플리케이션의 특정 HTTP 요청에 대해 어떤 보안 정책을 적용할지 구성하는 데 사용된다.
		//이를 통해 개발자는 다양한 보안 규칙을 쉽게 설정할 수 있다. 즉 이 객체를 사용해서 보안설정을 정의한다.
		http
			.authorizeHttpRequests(authorizeRequest -> //http 요청에 대한 보안 권한 설정 부분
				authorizeRequest
					.requestMatchers("/login").permitAll() // login 경로는 인증없이 누구든 접근 허용
					.anyRequest().authenticated() // 나머지 요청은 인증된 경우에 접근을 허용함	
			)
			.formLogin(formLogin -> 
				formLogin
				.loginPage("/login") // login 페이지 경로를 지정
				.defaultSuccessUrl("/", true) // login 성공시 컨텍스트 루트로 이동한다.
				.permitAll()	// login 페이지는 인증없이 누구든 접근 허용
					
			)
			.logout(logout ->
				logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout") //login.html 20번줄을 만나기위해서 이렇게 씀					
					.permitAll() // logout 페이지는 인증없이 누구든 접근 허용
					
			)
			.sessionManagement(sessionManagement ->
			 	sessionManagement
			 	.maximumSessions(1) // 최대 동시 세션 수를 제한 보통은 1
			 	.expiredUrl("/login?expired") // 세션 만료시 로그인으로 이동
			);
		
		return http.build();
	}
	
	//사용자가 적은 값을 리턴하기 위해서
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
							.username("kor")
							.password(passwordEncoder().encode("123"))
							.roles("USER") // default user 역할
							.build(); // 사용자명과 비밀번호 역할 설정
		
		return new InMemoryUserDetailsManager(user);
		// 사용자 정보를 메모리에 저장하고 관리하는 클래스 : InMemoryUserDetailsManager
		// 주로 어플리케이션, 테스트 환경에서 사용함, 영구 저장소x
		// 어플리케이션을 재시작하며 사라짐
	}
	
	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // 비밀번호 암호화를 BCrypt알고리즘 사용
		// 단방향 해시 함수를 이용하여 암호화를 수행
	}
}
