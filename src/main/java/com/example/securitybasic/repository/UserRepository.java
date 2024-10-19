package com.example.securitybasic.repository;

import com.example.securitybasic.domain.user.User;
import com.example.securitybasic.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    User getUserByUsername(String username);
}
