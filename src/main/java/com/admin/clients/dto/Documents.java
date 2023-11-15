package com.admin.clients.dto;

public class Documents<T> {

    private T responsedata;
    private String message;

    public T getResponsedata() {
        return responsedata;
    }

    public void setResponsedata(T responsedata) {
        this.responsedata = responsedata;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
