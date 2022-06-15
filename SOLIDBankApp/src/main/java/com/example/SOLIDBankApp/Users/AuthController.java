package com.example.SOLIDBankApp.Users;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    private String token;

    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        if(userService.findByLoginAndPassword(registrationRequest.getLogin(), registrationRequest.getPassword()) != null) return "User is already exists";
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setLogin(registrationRequest.getLogin());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/authenticate")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        if(user == null) return null;
        String token = jwtProvider.generateToken(user.getLogin(), user.getID());
        this.token = token;
        return new AuthResponse(token);
    }
    @PostMapping("/token")
    public AuthResponse token(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        if(user == null) return null;
        String token = jwtProvider.generateToken(user.getLogin(), user.getID());
        this.token = token;
        return new AuthResponse(token);
    }
}