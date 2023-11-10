package com.irfanYusufJBusRA.controller;

public class BaseResponse<T> {
    public boolean success;
    public String message;
    public T payload;

    public BaseResponse(boolean success, String message, T payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }
}
