package com.wiseassblog.startingpoint.di;

import com.wiseassblog.androidresttutorial.repolist.ListActivity;
import com.wiseassblog.androidresttutorial.repolist.ViewInterface;

import dagger.Binds;
import dagger.Module;

/**
 * Created by R_KAY on 11/15/2017.
 */
@Module
public abstract class RepositoryListModule {
    @Binds
    abstract ViewInterface provideFeatureView(ListActivity listActivity);

}
