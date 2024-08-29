package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// 클라이언트 요청 --> 필터 + 필터 ... + DispatcherServlet
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		// 인증 없이 접근 가능 요청(url)
		// 시큐리티 내용이 많으면 따로 빼서 whitelist 이렇게 만들면 좋아
		String[] whitelist = {
				"/", "/notice", "/user/loginform",
				"/user/login_fail", "/user/expired", "/shop"
						
		};
		
		httpSecurity
		.csrf(csrf -> csrf.disable()) // csrf 사용 안하기
		.authorizeHttpRequests(config -> // 사용자 인증 설정
			config
			.requestMatchers(whitelist).permitAll()
			.requestMatchers("/admin/**").hasRole("ADMIN") // 특정권한을 가진 사용자만 접근 허용
			.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
			.anyRequest().authenticated() // 그 외 나머지는 인증을 거쳐야되
			)
		.formLogin(config ->
			config
				.loginPage("/user/required_loginform")
				.loginProcessingUrl("/user/login") // 시큐리티가 자동으로 로그인 처리를 해줄 요청 경로를 설정
				.usernameParameter("userName") // 이때 username password를 알려야 함
				.passwordParameter("password")
				.successHandler(new AuthSuccessHandler()) // 로그인 성공 이후에 뭔가를 처리할 것이 있다면 핸들러를 등록해서 처리한다.
				.failureForwardUrl("/user/login_fail") // 로그인 실패시 이동할 경로를 설정
				.permitAll()
			)
		
		.logout(config ->
			config
				.logoutUrl("/user/logout") // 시큐리티가 자동으로 로그아웃 처리해 줄 경로 설정
				.logoutSuccessUrl("/") // 로그아웃 성공 시 루트로 가게 설정함(로그아웃 이후에 리다이렉트 경로 설정)
				.permitAll()
				)
		.exceptionHandling(config -> // 인증 처리 중 예외가 발생했을 때 설정. 권한 확인과정에서 예외가 발생한 경우.
			config
				.accessDeniedPage("/user/denied") // 시큐리티는 인증에 실패하면 403 forbidden을 발생시킨다. 이 때 이동할 경로를 설정
				)
		
		.sessionManagement(config ->
			config
				.maximumSessions(1) // 최대 허용 세션 갯수
				.expiredUrl("/user/expired") // 허용 세션 갯수가 넘어서 로그인인 해제된 경우 리다이렉트할 경로 지정
				);
		
		return httpSecurity.build(); 
	}
}
