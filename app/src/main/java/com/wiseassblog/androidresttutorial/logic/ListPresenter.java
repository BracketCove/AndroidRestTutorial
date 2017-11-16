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

package com.wiseassblog.androidresttutorial.logic;

import android.arch.lifecycle.LifecycleObserver;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import com.wiseassblog.androidresttutorial.data.DataSourceInterface;
import com.wiseassblog.androidresttutorial.data.GithubRepository;
import com.wiseassblog.androidresttutorial.repolist.ViewInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Please note that ListPresenter is intended to be a generic term for a Class which coordinates events
 * and logic. This is not me showing you how to implement MVC.
 * <p>
 * Created by R_KAY on 6/3/2017.
 */

public class ListPresenter implements LifecycleObserver {

    private ViewInterface view;
    private DataSourceInterface dataSource;
    private CompositeDisposable disposables;

    @Inject
    public ListPresenter(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;
        disposables = new CompositeDisposable();
    }

    public void start(String user) {
        getListFromDataSource(user);
    }

    public void stop() {
        disposables.clear();
    }

    public void getListFromDataSource(String user) {
        disposables.add(
                dataSource.getUserRepositories(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<List<GithubRepository>>() {
                    @Override
                    public void onNext(List<GithubRepository> repositories) {
                        view.setUpAdapterAndView(repositories);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("ERROR", t.getMessage() + " " + t.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }
}
