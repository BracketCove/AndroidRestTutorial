package com.wiseassblog.androidresttutorial.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * At the risk of some mild confusion, this class is the "Repository" in the context of a Repository
 * Pattern or Facade Pattern; not a GitHub Repository (don't blame me for everyone re-using the same
 * jargon for everything).
 *
 * This Class provides a layer of Abstraction over our DataSource, which is happens to be a REST
 * Adapter. The other parts of the App shouldn't know or care whether this is a Database or REST
 * Adapter. This way we may completely change the implementation of our Data Layer (a.k.a. Model
 * Layer in MVP/MVC/MVVM), without needing to change the Controller/Presenter/ViewModel.
 *
 * If you aren't doing this, I believe you should be doing this with your Data (imho).
 * Created by R_KAY on 11/14/2017.
 */

//Both this repository, and the REST Adapter will implement the same interface to enforce
// consistency.
public class RepositorySource implements DataSourceInterface {

    private DataSourceInterface restAdapter;

    @Inject
    public RepositorySource(DataSourceInterface restAdapter) {
        this.restAdapter = restAdapter;
    }

    @Override
    public Flowable<List<GithubRepository>> getUserRepositories(String user) {
            return restAdapter.getUserRepositories(user)
                    .subscribeOn(Schedulers.io());
    }
}
