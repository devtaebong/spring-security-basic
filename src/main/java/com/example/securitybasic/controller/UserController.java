package com.example.securitybasic.controller;

import com.example.securitybasic.controller.request.UserRegisterRequestBody;
import com.example.securitybasic.controller.response.ResultResponse;
import com.example.securitybasic.domain.user.CreateUser;
import com.example.securitybasic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/api/v1/register")
    public ResultResponse<String> register(@RequestBody UserRegisterRequestBody requestBody) {
        String result = userService.register(new CreateUser(requestBody.getUsername(), bCryptPasswordEncoder.encode(requestBody.getPassword())));
        return ResultResponse.ok(result);
    }
}
