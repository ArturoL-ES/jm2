package com.arturo.jm2api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.arturo.jm2api.common.Profiles;

@Configuration
@EnableWebSecurity
@Profile({Profiles.DEVEVELOPMENT})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired 
    @Qualifier("userService")
    private UserDetailsService userService;
    
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	   auth
	       .userDetailsService(userService)
	       .passwordEncoder(passwordEncoder());
	}
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //.antMatchers(HttpMethod.POST, "/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/**").authenticated()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()
                .anyRequest()
                    .permitAll()
            .and()
                .formLogin()
                    .loginProcessingUrl("/user/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(new CustomAuthenticationSuccessHandler())
                    .failureHandler(new CustomAuthenticationFailureHandler())
            .and()
                .logout()
                    .logoutUrl("/user/logout")
                    //.logoutSuccessHandler(new CustomLogoutSuccessHandler())
                    .deleteCookies("JSESSIONID")
            .and()
                .exceptionHandling()
                    .accessDeniedHandler(new AccessDeniedHandlerImpl())
                    .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
            .and()
				.csrf()
				    .disable(); // Until have profiles, for swagger.
			/*
					.csrfTokenRepository(csrfTokenRepository())
			.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
			*/
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
    
}
