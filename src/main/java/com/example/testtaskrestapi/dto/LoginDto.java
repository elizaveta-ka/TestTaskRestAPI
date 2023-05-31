package com.example.testtaskrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity User for Login")
public class LoginDto {

    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    @Min(4)
    @Max(10)
    private String password;
}
