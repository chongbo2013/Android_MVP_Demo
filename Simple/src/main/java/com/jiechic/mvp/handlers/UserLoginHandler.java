package com.jiechic.mvp.handlers;

public interface UserLoginHandler {
    void notifySuccess();
    void notifyError(String errorMessage);
    void notifyServerUnreachable(String s);
}
