/*
 * *
 *  * Copyright (C) 2017 Ryan Kay Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wiseassblog.androidresttutorial.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * This is the Class which actually talks to the REST endpoint. It can be thought of as a "Remote"
 * Datasource.
 *
 * Note that it implements the same interface as our RepositorySource; ensuring consistency between
 * such Model/Data Classes.
 * Created by R_KAY on 10/29/2017.
 */

public class GitHubRestAdapter implements DataSourceInterface {
    private static final String REPOS = "/users/{user}/repos";
    private final GitHubService github;

    /**
     * This interface defines methods used by Retrofit to communicate with a given API.
     * Each interface method, can be thought of as a RESTful method.
     */
    public interface GitHubService {
        @GET(REPOS)
        Flowable<List<GithubRepository>> getUserPublicRepositories(
                @Path("user") String user
        );
    }

    @Inject
    public GitHubRestAdapter(Retrofit retrofit) {
        github = retrofit.create(GitHubService.class);
    }

    @Override
    public Flowable<List<GithubRepository>> getUserRepositories(final String user) {
        return github.getUserPublicRepositories(user);
    }

}
