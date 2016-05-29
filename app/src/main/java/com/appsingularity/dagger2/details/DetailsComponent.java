package com.appsingularity.dagger2.details;


import com.appsingularity.dagger2.dagger.ActivityScope;

import dagger.Subcomponent;

/**
 * Scope: activity, it will be instantiated when the DetailsActivity starts.
 */
@ActivityScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent {

    void inject(DetailsActivity activity);

}
