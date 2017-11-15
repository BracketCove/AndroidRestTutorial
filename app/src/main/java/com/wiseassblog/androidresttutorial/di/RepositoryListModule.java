package com.wiseassblog.androidresttutorial.di;

import com.wiseassblog.androidresttutorial.view.ListActivity;
import com.wiseassblog.androidresttutorial.view.ViewInterface;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by R_KAY on 11/15/2017.
 */
@Module
public abstract class RepositoryListModule {
    @Binds
    abstract ViewInterface provideFeatureView(ListActivity listActivity);


}
