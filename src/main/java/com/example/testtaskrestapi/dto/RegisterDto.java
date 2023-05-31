package com.example.testtaskrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity User for Register")
public class RegisterDto {

    @NotEmpty(message = "Please provide a username")
    @Size(min = 4, max = 10)
    private String username;

    @NotEmpty(message = "Please provide a email")
    private String email;

    @NotEmpty(message = "Please provide a password")
    @Size(min = 4, max = 10)
    private String password;
}
