package com.jiechic.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import com.jiechic.mvp.presenters.LoginPresenter;
import com.jiechic.mvp.services.IUserService;
import com.jiechic.mvp.services.UserService;
import com.jiechic.mvp.util.SurveyWebHttpClient;
import com.jiechic.mvp.views.ILoginView;
import com.jiechic.mvp.views.LoginView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

    LoginPresenter mPresenter;
    ILoginView mLoginView;
    IUserService mUserService;

    Button mSignInButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginView=new LoginView(this);
        mUserService=new UserService(new SurveyWebHttpClient());
        mPresenter=new LoginPresenter(mUserService,mLoginView);

        mPresenter.onCreate();

        mSignInButtonView= (Button) findViewById(R.id.sign_in_button);

        mSignInButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.attemptLogin();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
}
