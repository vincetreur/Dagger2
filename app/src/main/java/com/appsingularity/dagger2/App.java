package com.appsingularity.dagger2;

import android.app.Application;
import android.support.annotation.NonNull;

import com.appsingularity.dagger2.dagger.AppComponent;
import com.appsingularity.dagger2.dagger.DaggerAppComponent;
import com.appsingularity.dagger2.dagger.UserComponent;
import com.appsingularity.dagger2.dagger.UserModule;

import timber.log.Timber;

public class App extends Application {

    private static AppComponent mAppComponent;
    private static UserComponent mUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        mAppComponent = DaggerAppComponent.builder().build();
        login("anonymous");
    }

    public static UserComponent login(@NonNull String name) {
        mUserComponent = mAppComponent.plus(new UserModule(name));
        return mUserComponent;
    }


    public static UserComponent userComponent() {
        return mUserComponent;
    }

}
