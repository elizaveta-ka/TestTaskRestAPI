package com.example.testtaskrestapi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@OpenAPIDefinition(
        info = @Info(
                title = "Test Task Rest API",
                description = "Before using the app, you need use api/auth/login endpoint, generate token, click authorize button and paste it", version = "1.0.0",
                contact = @Contact(
                        name = "Kabak Elizaveta",
                        email = "kabakelizaveta@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
