package com.example.securitybasic.repository.entity;

import com.example.securitybasic.domain.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "userEntity")
    @ManyToOne
    private UserEntity userEntity;

    public AuthorityEntity(String name, UserEntity userEntity) {
        this.name = name;
        this.userEntity = userEntity;
    }

    public Authority toAuthority() {
        return Authority.builder()
                .name(this.name)
                .build();
    }
}
