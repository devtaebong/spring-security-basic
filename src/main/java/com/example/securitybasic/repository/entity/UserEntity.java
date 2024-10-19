package com.example.securitybasic.repository.entity;

import com.example.securitybasic.domain.user.CreateUser;
import com.example.securitybasic.domain.EncryptionAlgorithm;
import com.example.securitybasic.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "authorities")
    private List<AuthorityEntity> authorities;

    public UserEntity(String username, String password, EncryptionAlgorithm algorithm) {
        this.username = username;
        this.password = password;
        this.algorithm = algorithm;
    }

    public User toUser() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .algorithm(this.algorithm)
                .authorities(this.authorities.stream().map(AuthorityEntity::toAuthority).toList())
                .build();
    }

    public void replaceAuthority(List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public static UserEntity newUser(CreateUser create) {
        return new UserEntity(
                create.getUsername(),
                create.getPassword(),
                EncryptionAlgorithm.BCRYPT
        );
    }
}
