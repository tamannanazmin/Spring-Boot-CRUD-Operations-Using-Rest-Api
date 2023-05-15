package com.example.learning.SpringBootCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data//we do not need to use getter setter method for this
//@NoArgsConstructor
//@AllArgsConstructor
public class ChatRequest {
    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatRequest(String model, String prompt) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    // getters and setters
}
