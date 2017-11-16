package com.wiseassblog.androidresttutorial.di;

import com.wiseassblog.androidresttutorial.repolist.ListActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by R_KAY on 11/15/2017.
 */
@Subcomponent(modules = RepositoryListModule.class)
public interface RepositoryListSubcomponent extends AndroidInjector<ListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ListActivity>{}

}
