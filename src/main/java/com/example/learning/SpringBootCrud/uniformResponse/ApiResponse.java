package com.example.learning.SpringBootCrud.uniformResponse;

public class ApiResponse {
    private Integer status;
    private Object data;
    private Object error;

    public ApiResponse() {
    }

    public ApiResponse(Integer status, Object data, Object error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
