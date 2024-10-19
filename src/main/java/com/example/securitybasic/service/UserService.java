package com.example.securitybasic.service;

import com.example.securitybasic.domain.user.CreateUser;
import com.example.securitybasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userJpaRepository;

    public String register(CreateUser createUser) {
        if (userJpaRepository.userExists(createUser.getUsername())) {
            throw new RuntimeException(String.format("User [%s] already exists", createUser.getUsername()));
        }

        return userJpaRepository.create(createUser).getUsername();
    }
}
