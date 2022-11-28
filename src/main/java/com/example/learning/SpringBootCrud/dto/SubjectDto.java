package com.example.learning.SpringBootCrud.dto;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data//we do not need to use getter setter method for this
public class SubjectDto {
    private String id;

    @NotEmpty(message = "Name Can not be Empty")
    @Size(min = 2, message = "User name should have at least 2 characters")
    private String name;

    @NotEmpty(message = "Name Can not be Empty")
    @Email(message = "Please enter valid email")
    private String email;
}
