package com.example.testtaskrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Schema(description = "Entity Post")
public class PostDto {

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @Length(max = 140)
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String text;

    private String image;
}
