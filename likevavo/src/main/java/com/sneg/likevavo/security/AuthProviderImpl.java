package com.sneg.likevavo.security;
import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import com.sneg.likevavo.service.UserDetailsServiceImpl;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserDetailsServiceImpl UserDetailsService;

    public AuthProviderImpl(UserDetailsServiceImpl UserDetailsService) {
        this.UserDetailsService = UserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails UserDetails = UserDetailsService.loadUserByUsername(username);
        String pass = authentication.getCredentials().toString();
        if(!pass.equals(UserDetails.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }
        return new UsernamePasswordAuthenticationToken(UserDetails, pass, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
}
