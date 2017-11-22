package com.wiseassblog.androidresttutorial;

import com.wiseassblog.androidresttutorial.data.RepositoryDataSourceInterface;
import com.wiseassblog.androidresttutorial.repolist.ListPresenter;
import com.wiseassblog.androidresttutorial.repolist.ViewInterface;
import com.wiseassblog.androidresttutorial.util.SchedulerProvider;
import com.wiseassblog.androidresttutorial.viewmodel.RepositoryListItem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import io.reactivex.Flowable;

/**
 * Created by R_KAY on 11/20/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListPresenterTest  {

    @Mock
    public ViewInterface view;

    @Mock
    public RepositoryDataSourceInterface dataSource;

    private ListPresenter presenter;

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);

        presenter = new ListPresenter(view, dataSource, new SchedulerProvider());

    }

    /**
     * When RepositoryDataSourceInterface returns AdapterTestData in onNext();
     *
     * Unit Testing 101:
     * Step 1: Set up Mocks/Data. This generally includes faking responses from the tested class'
     * dependencies.
     *
     * Step 2: Execute method to be Tested with a real version of the class to be tested.
     *
     * Step 3: At this point, you may either verify the behaviour, or state of the data, after
     * the Test has completed. This will depend on what you care about testing in the given moment.
     *
     * The Presenter doesn't mess with Data much, so for this Test I'll be making sure that the
     * correct method is called on the Mock View.
     *
     */
    @Test
    public void onGetUserRepositoriesSuccessful(){

        Mockito.when(dataSource.getUserRepositories(ListPresenterTestData.TEST_USERNAME))
                .thenReturn(Flowable.just(ListPresenterTestData.LIST_VIEW_MODEL_SUCCESS));

        presenter.getListFromDataSource(ListPresenterTestData.TEST_USERNAME);

        Mockito.verify(view).setUpAdapterAndView(Mockito.<RepositoryListItem>anyList());

    }

    @Test
    public void onGetUserRepositoriesFailed(){


        Mockito.when(dataSource.getUserRepositories(ListPresenterTestData.INVALID_USERNAME))
                .thenReturn(Flowable.just(ListPresenterTestData.LIST_VIEW_MODEL_FAILURE));

        presenter.getListFromDataSource(ListPresenterTestData.INVALID_USERNAME);

        Mockito.verify(view).showErrorMessage(ListPresenterTestData.ERROR_MESSAGE);
        Mockito.verify(view).startMainActivity();

    }

    @Test
    public void onGetUserRepositoriesLoading(){


        Mockito.when(dataSource.getUserRepositories(ListPresenterTestData.TEST_USERNAME))
                .thenReturn(Flowable.just(ListPresenterTestData.LIST_VIEW_MODEL_LOADING));

        presenter.getListFromDataSource(ListPresenterTestData.TEST_USERNAME);

        Mockito.verify(view).showLoadingIndicator();

    }
}
