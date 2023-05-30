package com.example.testtaskrestapi.dto;

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
public class RegisterDto {

    @NotBlank
    private String username;

    private String email;

    @NotBlank
    @Min(4)
    @Max(10)
    private String password;
}
