package com.appsingularity.dagger2.details;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.appsingularity.dagger2.App;
import com.appsingularity.dagger2.R;

import javax.inject.Inject;
import javax.inject.Named;

public class DetailsActivity extends AppCompatActivity {
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
        DetailsComponent detailsComponent = App.userComponent().plusDetails();
        detailsComponent.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(mTitle);

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(mAppName);
        TextView userView = (TextView) findViewById(R.id.user_view);
        userView.setText(getString(R.string.current_user, mUserName));
    }

}
