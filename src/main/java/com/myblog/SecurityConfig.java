package com.myblog;

import com.myblog.security.LoginFailHandler;
import com.myblog.security.LoginSuccessHandler;
import com.myblog.security.LogoutSuccessHandler;
import com.myblog.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//LoginSuccessHandler memberLoginSuccessHandler;

	//@Autowired
	//LoginFailHandler memberLoginFailHandler;

	//@Autowired
	//LogoutSuccessHandler memberLogoutSuccessHandler;

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		/*webSecurity.ignoring().antMatchers(
				"/resources/**",
				"/css/**",
				"/fonts/**",
				"/js/**",
				"/less/**",
				"/scss/**",
				"/images/**",
				"/webjars/**" ,
				"/img/**");*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()

				//페이지 권한 설정
				.antMatchers("/**").permitAll() //전체 접근 허용
				//.antMatchers("/user/*").hasRole("MEMBER")
				.antMatchers("/admin**").hasRole("ADMIN") //관리자만
				//api 예외 경로 추가
				.and()
				.csrf()
				.ignoringAntMatchers("/Api/boardRest")
				.ignoringAntMatchers("/Api/menuRest")
				//로그인 설정
				.and().formLogin()
				//.loginPage("/login") //로그인 화면
				//.loginProcessingUrl("/login") //프로세스 URL
				.defaultSuccessUrl("/index") //로그인 후
				//.successHandler(memberLoginSuccessHandler)
				//.failureHandler(memberLoginFailHandler)
				.permitAll()

				//로그아웃 설정
				.and()
				//.csrf()
				.logout()
				//.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/index")
				//.logoutSuccessHandler(memberLogoutSuccessHandler)
				
				//예외처리
				.and()
				.exceptionHandling().accessDeniedPage("/index")
				;
	}

	@Autowired
	private final MemberService memberService;

	//로그인 처리
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//System.out.println("configureGlobal");
		auth.userDetailsService(memberService);
	}
}
