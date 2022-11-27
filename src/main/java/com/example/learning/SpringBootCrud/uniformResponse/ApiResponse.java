package com.example.learning.SpringBootCrud.uniformResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Integer status;
    private Object data;
    private Object error;
}
