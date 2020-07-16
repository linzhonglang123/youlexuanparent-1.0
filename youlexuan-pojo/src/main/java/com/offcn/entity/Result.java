package com.offcn.entity;

import java.io.Serializable;

public class Result implements Serializable {

    private boolean success;

    private String messge;

    public Result(boolean success, String messge) {
        this.success = success;
        this.messge = messge;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }
}
