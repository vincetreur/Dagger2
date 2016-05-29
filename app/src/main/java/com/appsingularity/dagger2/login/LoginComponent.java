package com.appsingularity.dagger2.login;


import com.appsingularity.dagger2.dagger.ActivityScope;

import javax.inject.Named;

import dagger.Subcomponent;

/**
 * Scope: activity, it will be instantiated when the LoginActivity starts.
 */
@ActivityScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity activity);

}
