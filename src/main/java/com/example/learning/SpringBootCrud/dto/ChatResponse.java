package com.example.learning.SpringBootCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data//we do not need to use getter setter method for this
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {
    private List<Choice> choices;

    // constructors, getters and setters

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice {

        private int index;
        private Message message;

        // constructors, getters and setters
    }
}
