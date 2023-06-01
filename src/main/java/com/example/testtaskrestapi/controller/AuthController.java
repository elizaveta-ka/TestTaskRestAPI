package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.dto.JWTAuthResponse;
import com.example.testtaskrestapi.dto.LoginDto;
import com.example.testtaskrestapi.dto.RegisterDto;
import com.example.testtaskrestapi.exception.APIException;
import com.example.testtaskrestapi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@AllArgsConstructor
@ControllerAdvice
@Validated
@RestController
@Tag(name="Authentication and Authorization Controller", description="Register/Login")
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Authentication",
            description = "Login"
    )
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto) throws APIException {
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }


    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Registration",
            description = "Add new User"
    )
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) {

        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
