package com.example.securitybasic.repository;

import com.example.securitybasic.domain.user.CreateUser;
import com.example.securitybasic.domain.user.User;
import com.example.securitybasic.exception.UserNotFoundException;
import com.example.securitybasic.repository.entity.AuthorityEntity;
import com.example.securitybasic.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final AuthorityJpaRepository authorityJpaRepository;

    @Transactional(readOnly = true)
    public Boolean userExists(String username) {
        return userJpaRepository.findByUsername(username).isPresent();
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new)
                .toUser();
    }

    @Transactional
    public User create(CreateUser create) {
        UserEntity user = userJpaRepository.save(UserEntity.newUser(create));
        AuthorityEntity authority = authorityJpaRepository.save(new AuthorityEntity("READ", user));
        user.replaceAuthority(List.of(authority));

        return user.toUser();
    }
}
