package com.yuuLab.api.app.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
   @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        	.authorizeRequests()
            .anyRequest()
//            .permitAll()
            .authenticated()
            .and()
            .exceptionHandling()
            	.authenticationEntryPoint(authenticationEntryPoint())
            	.accessDeniedHandler(accessDeniedHandler())
            .and()
            .csrf().disable()
            .addFilter(preAuthenticatedProcessingFilter())
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    }

    // 作成したユーザサービス
    @Bean
    public AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> authenticationUserDetailsService() {
        return new AuthenticationService();
    }

    // フィルター登録
    @Bean
    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {

    	PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(authenticationUserDetailsService());
        preAuthenticatedAuthenticationProvider.setUserDetailsChecker(new AccountStatusUserDetailsChecker());

        return preAuthenticatedAuthenticationProvider;
    }

    // 作成したフィルター
    @Bean
    public AbstractPreAuthenticatedProcessingFilter preAuthenticatedProcessingFilter() throws Exception {

    	AbstractPreAuthenticatedProcessingFilter preAuthenticatedProcessingFilter = new PreAuthenticatedProcessingFilter();
        preAuthenticatedProcessingFilter.setAuthenticationManager(authenticationManager());
        return preAuthenticatedProcessingFilter;
    }
    
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new SimpleAuthenticationEntryPoint();
    }
    
    AccessDeniedHandler accessDeniedHandler() {
        return new SimpleAccessDeniedHandler();
    }
}
