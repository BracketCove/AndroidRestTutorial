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
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by R_KAY on 10/29/2017.
 */

public class GitHubRestAdapter implements DataSourceInterface {
    private static final String REPOS = "/user/{user}/repos";
    private final GitHubService github;

    /**
     * This interface defines methods used by Retrofit to communicate with a given API.
     * Each interface method, can be thought of as a RESTful method.
     */
    public interface GitHubService {
        @GET(REPOS)
        Call<List<Repository>> getUserPublicRepositories(
                @Query("user") String user
        );
    }

    @Inject
    public GitHubRestAdapter(Retrofit retrofit) {
        github = retrofit.create(GitHubService.class);
    }

    @Override
    public Flowable<List<Repository>> getUserRepositories(final String user) {
        return Flowable.create(
                new FlowableOnSubscribe<List<Repository>>() {
                    @Override
                    public void subscribe(FlowableEmitter<List<Repository>> e) throws Exception {
                       Call<List<Repository>> call = github.getUserPublicRepositories(user);
                       e.onNext(call.execute().body());
                    }
                }
                ,
                BackpressureStrategy.LATEST);
    }

}
