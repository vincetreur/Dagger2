package com.appsingularity.dagger2.main;


import com.appsingularity.dagger2.dagger.ActivityScope;

import javax.inject.Named;

import dagger.Subcomponent;

/**
 * Scope: activity, it will be instantiated when the MainActivity starts.
 */
@ActivityScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);

}
