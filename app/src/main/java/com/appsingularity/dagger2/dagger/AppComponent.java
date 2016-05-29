package com.appsingularity.dagger2.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Scope: application, it will live as long as the application (class) is around.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    UserComponent plus(UserModule userModule);

}
