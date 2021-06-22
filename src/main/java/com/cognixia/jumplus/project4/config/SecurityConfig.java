package com.cognixia.jumplus.project4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**Handles the security of the API.
 * <p>
 * @author	Alexandré Northouse
 * @version	1.0
 * @since	2020-06-22
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService uDetailsService;
	
	/** Handles the authentication of the users. */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//TODO Change security configuration to match project
		auth.inMemoryAuthentication()
			.withUser("user") // user with this password allowed access
			.password(passwordEncoder().encode("password")) // encoding password
			.roles("USER_ROLE")
			.and()                // can add more users with and method
			.withUser("admin")
			.password(passwordEncoder().encode("password1234"))
			.roles("ADMIN_ROLE");
	}
	
	
	/** Handles the encoding of passwords during authentication */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	/** Handles what user types have access to what resources / endpoints */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//TODO Change URLs to match project
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/admin").hasRole("ADMIN_ROLE")
		.antMatchers("/api/car").hasRole("USER_ROLE")
		.antMatchers("/api/car/*").hasRole("ADMIN_ROLE")
		.antMatchers("/error").permitAll()
		.and()
		.formLogin()
		.and().httpBasic();
	}
}
