package com.example.learning.SpringBootCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//we do not need to use getter setter method for this
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String role;
    private String content;

    // constructor, getters and setters
}
