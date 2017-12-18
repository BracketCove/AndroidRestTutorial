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

import com.wiseassblog.androidresttutorial.datamodel.RepositoryDataModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * What does this class do?
 * This is the Class which actually talks to the REST endpoint. It can be thought of as a "Remote"
 * Datasource.
 *
 * Note that it implements the same interface as our RepositoryDataSourceImpl; ensuring consistency between
 * such Model/Data Classes.
 *
 * Why is it called Adapter?
 * This Class acts as the "go-between", or adapter, between our Application and GitHub's Web App.
 * The adaption can be thought of two ways:
 * - Via Retrofit + OKHttp, or Java code gets turned into HTTP Requests (messages)
 * - Via Retrofit + OkHttp + JSON Serializer, HTTP Responses which contain the JSON data are adapted
 * into Java objects we can use in our Application.
 *
 * Created by R_KAY on 10/29/2017.
 */

public class GitHubRestAdapter {

    private final GitHubService github;

    /**
     * This interface defines methods used by Retrofit to communicate with a given API.
     * Each interface method, can be thought of as a RESTful method.
     */
    public interface GitHubService {
        @GET(UrlManager.REPOS)
        Flowable<List<RepositoryDataModel>> getUserPublicRepositories(
                @Path("user") String user
        );
    }

    @Inject
    public GitHubRestAdapter(Retrofit retrofit) {
        github = retrofit.create(GitHubService.class);
    }

    public Flowable<List<RepositoryDataModel>> getUserRepositories(final String user) {
        return github.getUserPublicRepositories(user);
    }
}
