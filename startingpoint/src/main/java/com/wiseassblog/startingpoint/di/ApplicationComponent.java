package com.wiseassblog.startingpoint.di;

import com.wiseassblog.startingpoint.GitHubApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by R_KAY on 11/15/2017.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        BuildersModule.class
})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(GitHubApplication application);
        ApplicationComponent build();
    }

    void inject(GitHubApplication application);
}
