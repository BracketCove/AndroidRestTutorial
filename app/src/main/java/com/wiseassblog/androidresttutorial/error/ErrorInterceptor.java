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

package com.wiseassblog.androidresttutorial.error;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 *
 * Interceptors allow us to grab Requests and Responses between Layers of Implementation. In simpler
 * terms:
 * - Checks Requests prior to being sent over the Network
 * - Checks Responses prior to when our GitHubRestAdapter calls back to the Repository.
 *
 * Among other useful things (see OkHttp Docs for more info), we can perform some global error
 * handling operations. Errors will still be propogated to onErrorReturn() in the Repository.
 * Created by R_KAY on 10/29/2017.
 */

public class ErrorInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            throw new GitHubError(
                    response.code(),
                    response.message()
            );
        }
            return response;
    }
}
