/**
 * 
 */
package com.rianta9.mona.config;

import javax.sql.DataSource;

/**
 * @author rianta9
 * @datecreated 22 thg 4, 2021 23:45:49
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.context.annotation.SessionScope;

import com.rianta9.mona.security.UserContext;
/**
 * 
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	DataSource dataSource;
	
	@Bean
	@SessionScope
	public UserContext userContext() {
		return new UserContext();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

		// Setting không xóa password sau khi xác thực
		// Nếu xóa thì password sẽ bằng null.
		auth.eraseCredentials(false); // default : true
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); 
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/admin/dist/**").permitAll()
		.antMatchers("/ckfinder/**").permitAll()
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.failureUrl("/login?error").and().exceptionHandling().accessDeniedPage("/403");
		
		// Cấu hình cho Logout Page.
        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
		
		// Cấu hình Remember Me.
        http.authorizeRequests().and() //
        .rememberMe()
        // .alwaysRemember(true) // default : false : ko remember, phải chọn remember
        .rememberMeParameter("remember-me") // default : remember-me
        .rememberMeCookieName("RememberMe") // default : remember-me
        .tokenRepository(this.persistentTokenRepository()) //
        .tokenValiditySeconds(1 * 24 * 60 * 60); // custom 24h // default : 2 weeks
	}

	// Token stored in Table (Persistent_Logins)
	// Table phải tự tạo, schema trong file readme.txt
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}

}
