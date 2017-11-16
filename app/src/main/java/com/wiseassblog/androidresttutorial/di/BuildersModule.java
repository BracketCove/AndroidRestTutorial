package com.wiseassblog.androidresttutorial.di;

import android.app.Activity;

import com.wiseassblog.androidresttutorial.repolist.ListActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by R_KAY on 11/15/2017.
 */

@Module
public abstract class BuildersModule {

    //Add Bindings to Sub-Components here
    @Binds
    @IntoMap
    @ActivityKey(ListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindListActivityInjectorFactory(RepositoryListSubcomponent.Builder builder);


}
