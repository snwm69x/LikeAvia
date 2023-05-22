package com.sneg.likevavo.security;
import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.sneg.likevavo.service.UserDetailsServiceImpl;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserDetailsServiceImpl UserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public AuthProviderImpl(UserDetailsServiceImpl UserDetailsService, PasswordEncoder passwordEncoder) {
        this.UserDetailsService = UserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails UserDetails = UserDetailsService.loadUserByUsername(username);
        String pass = authentication.getCredentials().toString();
        String encodedpass = passwordEncoder.encode(pass);
        if(encodedpass.equals(UserDetails.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }
        return new UsernamePasswordAuthenticationToken(UserDetails, pass, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
}
