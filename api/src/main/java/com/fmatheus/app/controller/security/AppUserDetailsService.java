package com.fmatheus.app.controller.security;

import com.fmatheus.app.model.entity.UserEntity;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.fmatheus.app.model.service.impl.UserServiceImpl;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(AppUserDetailsService.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Username: " + username);
        Optional<UserEntity> optional = userServiceImpl.findByUsername(username);
        UserEntity user = optional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorreto."));
        return new UserSecury(user, this.authorities(user));
    }

    private Collection<? extends GrantedAuthority> authorities(UserEntity user) {
        Set<SimpleGrantedAuthority> authoritys = new HashSet<>();
        user.getPermissions().forEach(p -> authoritys.add(new SimpleGrantedAuthority(p.getName().toUpperCase())));
        return authoritys;
    }

}
