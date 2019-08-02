package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//authorizeRequests로 intercept할 수 있다(여러개를)
		http
			.authorizeRequests()
				.antMatchers("/admin/**")
					.hasRole("ADMIN") // "/admin/**" 의 요청에 대해선 ADMIN만 가능하게 하겠다
				.antMatchers("/student/**")
					.hasAnyRole("STUDENT","ADMIN")
				.and()
			.formLogin()
				.loginPage("/member/login")
				.loginProcessingUrl("/member/login")
				.defaultSuccessUrl("/index")
				.and()
			.logout()
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/index")
			//	.and()
			//.csrf()
			//	.disable()
			;
		
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT ID USERNAME,PWD PASSWORD,1 ENABLED FROM MEMBER WHERE ID = ?")
				.authoritiesByUsernameQuery("SELECT ID USERNAME, 'ROLE_ADMIN' AUTHORITY FROM MEMBER WHERE ID = ?")
				.passwordEncoder(new BCryptPasswordEncoder())
			;
					
	}
	
	
	
}












