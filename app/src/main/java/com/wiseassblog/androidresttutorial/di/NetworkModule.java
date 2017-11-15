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

package com.wiseassblog.androidresttutorial.di;

import android.content.Context;

import com.wiseassblog.androidresttutorial.error.ErrorInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * This is where we build the stuff necessary for our Retrofit REST Adapter to work properly.
 *
 * By building it via D.I., we remove lots of code and implementation details which shouldn't be
 * present within our Retrofit Adapter itself.
 * Created by R_KAY on 10/29/2017.
 */

public class NetworkModule {
    private final Retrofit retrofit;
    private final OkHttpClient client;

    private static final String API_HOST = "https://api.github.com";

    public NetworkModule(Context context) {
        OkHttpClient client =
                new OkHttpClient.Builder()
                        .addInterceptor(
                                new ErrorInterceptor()
                        ).build();

        this.retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        this.client = client;
    }



}
