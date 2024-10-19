package com.example.securitybasic.domain.user;

import com.example.securitybasic.domain.Authority;
import com.example.securitybasic.domain.EncryptionAlgorithm;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class User {
    private String username;
    private String password;
    private EncryptionAlgorithm algorithm;
    private List<Authority> authorities;
}
