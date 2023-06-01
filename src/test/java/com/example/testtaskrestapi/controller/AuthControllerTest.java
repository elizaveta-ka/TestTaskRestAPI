package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.dto.RegisterDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuthController.class)
@DisplayName("Тестирование контроллера регистрации")
public class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;
    private static ObjectMapper mapper;

    @Test
    @DisplayName("Добавление. Имя должно быть заполнено")
    void addWithEmptyName() throws Exception {
        MvcResult response = mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{}"))
                .andExpect(status().isBadRequest())
                .andReturn();

        String message = requireNonNull(response.getResolvedException(), "Не получено сообщение от контроллера").getMessage();
        assertTrue(message.contains("default message [name]"));
        assertTrue(message.contains("default message [Необходимо указать имя]"));
    }

    @Test
    @DisplayName("Принудительная валидация находит ошибку")
    void manualValidationTest() {
        RegisterDto emp = new RegisterDto(null, "email@server.com", null);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RegisterDto>> violations = validator.validate(emp);

        ConstraintViolation<RegisterDto> violation = violations.stream().findFirst().orElseThrow(() -> new RuntimeException(""));
        assertEquals("name", violation.getPropertyPath().toString());
        assertEquals("Необходимо указать имя", violation.getMessageTemplate());
    }

}
