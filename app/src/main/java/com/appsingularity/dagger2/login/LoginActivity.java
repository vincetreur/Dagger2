package com.appsingularity.dagger2.login;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.appsingularity.dagger2.App;
import com.appsingularity.dagger2.R;

import javax.inject.Inject;
import javax.inject.Named;

public class LoginActivity extends AppCompatActivity {
    @Inject
    @Named("AppName")
    String mAppName;
    @Inject
    @Named("UserName")
    String mUserName;
    @Inject
    @Named("title")
    String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setup();

        View btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }


    private void setup() {
        LoginComponent loginComponent = App.userComponent().plusLogin();
        loginComponent.inject(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(mTitle);

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(mAppName);
        TextView userView = (TextView) findViewById(R.id.user_view);
        userView.setText(getString(R.string.current_user, mUserName));
    }

    private void doLogin() {
        TextView usernameView = (TextView) findViewById(R.id.user_name);
        String userName = usernameView.getText().toString();

        App.login(userName);
        setup();
    }

}
