package com.example.securitybasic.repository;

import com.example.securitybasic.repository.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityJpaRepository extends JpaRepository<AuthorityEntity, Long> {
}
