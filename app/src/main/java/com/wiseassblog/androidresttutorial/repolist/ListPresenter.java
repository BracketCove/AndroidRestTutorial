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

package com.wiseassblog.androidresttutorial.repolist;

import android.arch.lifecycle.LifecycleObserver;
import android.util.Log;

import javax.inject.Inject;

import com.wiseassblog.androidresttutorial.data.RepositoryDataSourceInterface;
import com.wiseassblog.androidresttutorial.util.BaseSchedulerProvider;
import com.wiseassblog.androidresttutorial.viewmodel.ListViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Pretty typical Presenter implementation.
 * <p>
 * Created by R_KAY on 6/3/2017.
 */

public class ListPresenter implements LifecycleObserver {

    private ViewInterface view;
    private RepositoryDataSourceInterface dataSource;
    private CompositeDisposable disposables;
    private BaseSchedulerProvider scheduler;

    @Inject
    public ListPresenter(ViewInterface view,
                         RepositoryDataSourceInterface dataSource,
                         BaseSchedulerProvider scheduler) {
        this.view = view;
        this.dataSource = dataSource;
        this.disposables = new CompositeDisposable();
        this.scheduler = scheduler;
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
                        .observeOn(scheduler.getUiScheduler())
                        .startWith(
                                ListViewModel.loading()
                        )
                        .onErrorReturn(
                                //handle exceptions which occur outside of the response object from retrofit
                                new Function<Throwable, ListViewModel>() {
                                    @Override
                                    public ListViewModel apply(Throwable throwable) throws Exception {

                                        return ListViewModel.error(throwable.getMessage());
                                    }
                                }
                        )
                        .subscribeWith(new DisposableSubscriber<ListViewModel>() {
                            @Override
                            public void onNext(ListViewModel uiModel) {
                                if (uiModel.hasError()) {
                                    view.showErrorMessage(uiModel.getErrorMessage());
                                    view.startMainActivity();
                                } else if (uiModel.isLoading()) {
                                    view.showLoadingIndicator();
                                } else {
                                    view.setUpAdapterAndView(uiModel.getRepoList());
                                }
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
