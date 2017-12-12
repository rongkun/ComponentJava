package com.kun.baselib.base;


import com.google.gson.annotations.Expose;

/**
 * Created by kun on 16/10/17
 */
public class BaseResponse<T> {

    @Expose
    private String message;
    @Expose
    private int status;
    @Expose
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
