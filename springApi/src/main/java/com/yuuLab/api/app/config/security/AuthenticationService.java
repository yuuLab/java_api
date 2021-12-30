package com.yuuLab.api.app.config.security;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
	
	/**
	 * 実際にはプロジェクトに合わせて権限まわりを検討する。
	 * 今回は動作確認のためオンメモリーでここに保持する。
	 */
	private static final String AUTH_NAME = "yuulabApi";

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {

        // フィルタで取得したAuthorizationヘッダの値
        String credential = token.getCredentials().toString();

        if (StringUtils.isEmpty(credential)) {
            throw new UsernameNotFoundException("Authorization header must not be empty.");
        }
        
        if (Objects.equals(AUTH_NAME, credential)) {
        	return new User("user", "", AuthorityUtils.createAuthorityList("ApiUser"));
        } else {
        	throw new UsernameNotFoundException("Invalid authorization header.");
        }
    }
}
