package com.wiseassblog.androidresttutorial.di;

import android.content.Context;

import com.wiseassblog.androidresttutorial.GitHubApplication;
import com.wiseassblog.androidresttutorial.data.DataSourceInterface;
import com.wiseassblog.androidresttutorial.data.GitHubRestAdapter;
import com.wiseassblog.androidresttutorial.data.RepositorySource;
import com.wiseassblog.androidresttutorial.data.UrlManager;
import com.wiseassblog.androidresttutorial.error.ErrorInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by R_KAY on 11/15/2017.
 */
@Module(subcomponents = {RepositoryListSubcomponent.class})
public class ApplicationModule {

    private static final String REPOS = "/users/{user}/repos";


    @Provides
    Context provideContext(GitHubApplication application){
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    DataSourceInterface provideDataSource(GitHubRestAdapter adapter){
        return new RepositorySource(adapter);
    }

    @Provides
    @Singleton
    GitHubRestAdapter provideRestAdapter(Retrofit retrofit){
        return new GitHubRestAdapter(retrofit);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        OkHttpClient client =
                new OkHttpClient.Builder()
                        .addInterceptor(
                                new ErrorInterceptor()
                        ).build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(UrlManager.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
