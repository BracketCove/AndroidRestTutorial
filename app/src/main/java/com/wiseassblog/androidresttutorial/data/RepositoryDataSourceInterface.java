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

import com.wiseassblog.androidresttutorial.viewmodel.ListViewModel;

import io.reactivex.Flowable;

/**
 * This interface is the Contract which dictates how our ListPresenter can talk to our Data Layer and
 * Vice Versa.
 *
 * @see <a href="https://www.youtube.com/watch?v=VCmi0gBxd0E">Android Java Interfaces by Example</a>
 * Created by R_KAY on 6/3/2017.
 */

public interface RepositoryDataSourceInterface {

    Flowable<ListViewModel> getUserRepositories(String user);

}
