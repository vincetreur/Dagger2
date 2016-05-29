package com.appsingularity.dagger2.main;

import com.appsingularity.dagger2.dagger.ActivityScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class MainModule {

    @ActivityScope
    @Provides
    @Named("title")
    public String title() {
        // An 'object' that is only used in one activity
        Timber.i("Dagger creating main title");
        return "Main";
    }

}
