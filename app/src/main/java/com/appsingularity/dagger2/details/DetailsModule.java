package com.appsingularity.dagger2.details;

import com.appsingularity.dagger2.dagger.ActivityScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class DetailsModule {

    @ActivityScope
    @Provides
    @Named("title")
    public String title() {
        // An 'object' that is only used in one activity
        Timber.i("Dagger creating details title");
        return "Details";
    }

}
