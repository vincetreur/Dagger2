package com.appsingularity.dagger2.dagger;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class AppModule {

    @Singleton
    @Provides
    @Named("AppName")
    public String appName() {
        // Stable 'object' that is re-used across multiple activities
        Timber.i("Dagger creating app title");
        return "Dagger 2 Sample";
    }

}
