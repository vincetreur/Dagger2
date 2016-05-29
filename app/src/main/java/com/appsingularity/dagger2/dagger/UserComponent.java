package com.appsingularity.dagger2.dagger;


import com.appsingularity.dagger2.details.DetailsComponent;
import com.appsingularity.dagger2.login.LoginComponent;
import com.appsingularity.dagger2.main.MainComponent;

import dagger.Subcomponent;

/**
 * Scope: user session, switch to a new instance when a user logs in.
 */
@UserScope
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    MainComponent plusMain();
    LoginComponent plusLogin();
    DetailsComponent plusDetails();

}
