package com.appsingularity.dagger2.dagger;

import android.support.annotation.NonNull;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class UserModule {
    private String mUserName;

    public UserModule(@NonNull String userName) {
        mUserName = userName;
    }

    @UserScope
    @Provides
    @Named("UserName")
    public String userName() {
        Timber.i("Dagger creating user name");
        return mUserName;
    }

}
