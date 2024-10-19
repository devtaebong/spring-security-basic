package com.example.securitybasic.security;

import com.example.securitybasic.domain.user.User;
import com.example.securitybasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {
    private final UserRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUsername = userJpaRepository.getUserByUsername(username);
        return new CustomUserDetails(userByUsername);
    }
}
