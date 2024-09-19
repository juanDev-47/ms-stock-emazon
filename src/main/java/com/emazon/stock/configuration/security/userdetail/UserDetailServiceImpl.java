package com.emazon.stock.configuration.security.userdetail;

import com.emazon.stock.adapters.driven.feigns.client.AuthorizationFeign;
import com.emazon.stock.adapters.driven.feigns.dto.request.AuthorizationRequest;
import com.emazon.stock.adapters.driven.feigns.dto.response.AuthorizationResponse;
import com.emazon.stock.configuration.security.jwtfilter.JwtService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final JwtService jwtService;


    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        String email = jwtService.getClaim(token, Claims::getSubject);
        String role = jwtService.getClaim(token, claim -> claim.get("role")).toString();

        Collection<? extends GrantedAuthority> authorities =
                Set.of(new SimpleGrantedAuthority(role));

        return new User(email, token, authorities);
    }
}
