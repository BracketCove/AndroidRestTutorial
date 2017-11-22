package com.wiseassblog.androidresttutorial.data;

import com.wiseassblog.androidresttutorial.datamodel.RepositoryDataModel;
import com.wiseassblog.androidresttutorial.error.EmptyDatasetException;
import com.wiseassblog.androidresttutorial.viewmodel.RepositoryListItem;
import com.wiseassblog.androidresttutorial.viewmodel.ListViewModel;

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

    @Override
    public Flowable<ListViewModel> getUserRepositories(String user) {


        return restAdapter.getUserRepositories(user)
                .flatMap(new Function<Response<List<RepositoryDataModel>>,
                        Publisher<ListViewModel>>() {
                    @Override
                    public Publisher<ListViewModel>
                    apply(Response<List<RepositoryDataModel>> response) throws Exception {
                        //Unless I'm missing something, we shouldn't need to check
                        // response.isSuccessful here since it was handled in ErrorIntercepter.java
                            List<RepositoryListItem> listItems
                                    = new ArrayList<>();

                            if (response.body().size() == 0){
                                throw new EmptyDatasetException();
                            }

                            //map from RepositoryDataModel to RepositoryListItem
                            for (RepositoryDataModel repo : response.body()) {
                                listItems.add(
                                        new RepositoryListItem(
                                                repo.getDescription(),
                                                repo.getCreated_at(),
                                                repo.getAvatarUrl()
                                        )
                                );
                            }
                            return Flowable.just(ListViewModel.success(listItems));
                    }
                })
                .onErrorReturn(
                        //handle exceptions which occur outside of the response object from retrofit
                        //This is because
                        new Function<Throwable, ListViewModel>() {
                                   @Override
                                   public ListViewModel apply(Throwable throwable) throws Exception {

                                       return ListViewModel.error(throwable.getMessage());
                                   }
                               }
                )
                .startWith(
                         ListViewModel.loading()
                )
                .subscribeOn(Schedulers.io());
    }
}
