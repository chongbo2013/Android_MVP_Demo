package com.jiechic.mvp.presenters;

import android.text.TextUtils;
import com.jiechic.mvp.handlers.UserLoginHandler;
import com.jiechic.mvp.models.User;
import com.jiechic.mvp.services.IUserService;
import com.jiechic.mvp.views.ILoginView;


public class LoginPresenter {
    private IUserService userService;
    private ILoginView loginView;

    public LoginPresenter(IUserService userService, ILoginView loginView) {
        this.userService = userService;
        this.loginView = loginView;
    }

    public void onCreate() {
        this.loginView.onCreate();
    }

    public void attemptLogin() {
        loginView.reset();

        if (validate()) {
            login();
        }
    }

    private void login() {
        loginView.showSigningIn();
        userService.login(new User(loginView.getEmail(), loginView.getPassword()), new UserLoginHandler() {
            @Override
            public void notifySuccess() {
                loginView.hideSigningIn();
                loginView.showLoginSuccess();
            }

            @Override
            public void notifyError(String errorMessage) {
                loginView.hideSigningIn();
                loginView.showLoginError();
            }

            @Override
            public void notifyServerUnreachable(String s) {
                loginView.hideSigningIn();
                loginView.showTimeoutError();
            }
        });
    }

    private boolean validate() {
        if (TextUtils.isEmpty(loginView.getPassword())) {
            loginView.setPasswordRequiredError();
            return false;
        }
        if (TextUtils.isEmpty(loginView.getEmail())) {
            loginView.setEmailRequiredError();
            return false;
        }
        if (!loginView.getEmail().contains("@")) {
            loginView.setEmailInvalidError();
            return false;
        }
        return true;
    }
}
