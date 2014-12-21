package com.jiechic.mvp.services;


import com.jiechic.mvp.handlers.UserLoginHandler;
import com.jiechic.mvp.models.User;

public interface IUserService {
    void login(User user, UserLoginHandler userLoginHandler);
}
