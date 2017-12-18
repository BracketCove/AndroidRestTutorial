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
import com.wiseassblog.androidresttutorial.error.EmptyDatasetException;
import com.wiseassblog.androidresttutorial.viewmodel.ListViewModel;
import com.wiseassblog.androidresttutorial.viewmodel.RepositoryListItem;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * At the risk of some mild confusion, this class is the "Repository" in the context of a Repository
 * Pattern or Facade Pattern; not a GitHub Repository (don't blame me for everyone re-using the same
 * jargon for everything).
 * <p>
 * This Class provides a layer of Abstraction over our DataSource, which is happens to be a REST
 * Adapter. The other parts of the App shouldn't know or care whether this is a Database or REST
 * Adapter. This way we may completely change the implementation of our Data Layer (a.k.a. Model
 * Layer in MVP/MVC/MVVM), without needing to change the ListPresenter/Presenter/ViewModel.
 * <p>
 * If you aren't doing this, I believe you should be doing this with your Data (imho).
 * Created by R_KAY on 11/14/2017.
 */

//Both this repository, and the REST Adapter will implement the same interface to enforce
// consistency.
public class RepositoryDataSourceImpl implements RepositoryDataSourceInterface {

    private GitHubRestAdapter restAdapter;

    @Inject
    public RepositoryDataSourceImpl(GitHubRestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    /**
     * This method does the following things:
     * 1. Ultimately return a Flowable of type ListViewModel
     * 2. Return a Flowable of type List<RepositoryDataModel> from the restAdapter
     * 3. Transform emissions from restAdapter's Flowable, to a new Flowable of type ListViewModel,
     * then emit from that Flowable.
     * 4. Function refers to restAdapter.getUserRepositories(user)
     * 5. Publisher refers to apply is supposed to return (which is a Flowable of type ListViewModel
     * 6. This is what we do to 4, to get 5 (it makes sense if you don't think about it, trust me)
     * 7. Do that work off of the UI thread
     * @param user
     * @return
     */
    @Override
    public Flowable<ListViewModel> getUserRepositories(String user) {
        //1:
        return //2:
                restAdapter.getUserRepositories(user)
                 //3:
                .flatMap(
                         //4:
                        new Function<List<RepositoryDataModel>,
                                //5:
                                Publisher<ListViewModel>>() {
                            @Override
                            public Publisher<ListViewModel>
                            apply(List<RepositoryDataModel> response) throws Exception {
                                //6:
                                List<RepositoryListItem> listItems
                                        = new ArrayList<>();

                                if (response.size() == 0) {
                                    throw new EmptyDatasetException();
                                }

                                //map from RepositoryDataModel to RepositoryListItem
                                for (RepositoryDataModel repo : response) {
                                    listItems.add(
                                            new RepositoryListItem(
                                                    repo.getDescription(),
                                                    repo.getCreated_at(),
                                                    repo.getAvatarUrl()
                                            )
                                    );
                                }
                                return Flowable.just(ListViewModel.success(listItems));
                                // 6 ends here
                            }
                        })
                        //7
                .subscribeOn(Schedulers.io());
    }
}
