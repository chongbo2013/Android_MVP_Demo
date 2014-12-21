package com.jiechic.mvp.services;

import com.jiechic.mvp.handlers.UserLoginHandler;
import com.jiechic.mvp.models.User;
import com.jiechic.mvp.services.IUserService;
import com.jiechic.mvp.util.SurveyWebHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.client.HttpResponseException;

public class UserService implements IUserService {

    private SurveyWebHttpClient client;

    public UserService(SurveyWebHttpClient client) {
        this.client = client;
    }

    @Override
    public void login(User user, final UserLoginHandler userLoginHandler) {
        RequestParams params = new RequestParams();
        params.put("username", user.getUsername());
        params.put("password", user.getPassword());

        userLoginHandler.notifySuccess();

//        client.post("/api/login", params, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(String s) {
//                userLoginHandler.notifySuccess();
//            }
//
//            @Override
//            public void onFailure(Throwable throwable, String s) {
//                if (throwable.getClass().equals(HttpResponseException.class)){
//                    userLoginHandler.notifyError(s);
//                }
//                else {
//                    userLoginHandler.notifyServerUnreachable(s);
//                }
//            }
//        });
    }
}
