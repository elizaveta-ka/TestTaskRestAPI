package com.example.testtaskrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity User for Register")
public class RegisterDto {

    private String username;

    private String email;

    private String password;
}
