package com.appsingularity.dagger2.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.appsingularity.dagger2.App;
import com.appsingularity.dagger2.R;
import com.appsingularity.dagger2.details.DetailsActivity;
import com.appsingularity.dagger2.login.LoginActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

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
        MainComponent mainComponent = App.userComponent().plusMain();
        mainComponent.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(mAppName);
        TextView userView = (TextView) findViewById(R.id.user_view);
        userView.setText(getString(R.string.current_user, mUserName));

        View btn = findViewById(R.id.btn_show_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });
        btn = findViewById(R.id.btn_show_details);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetails();
            }
        });
    }

    private void showDetails() {
        startActivity(new Intent(this, DetailsActivity.class));
    }

    private void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

}
