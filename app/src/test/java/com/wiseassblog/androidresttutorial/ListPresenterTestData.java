package com.wiseassblog.androidresttutorial;

import com.wiseassblog.androidresttutorial.viewmodel.ListViewModel;
import com.wiseassblog.androidresttutorial.viewmodel.RepositoryListItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by R_KAY on 11/20/2017.
 */

public class ListPresenterTestData {
    public static final String TEST_USERNAME = "BracketCove";

    public static final String INVALID_USERNAME = "agfhaslkfjgeagagadgjskdfl";

    public static final String REPO_DESCRIPTION = "This is a Description of some GitHub Repository.";

    public static final String REPO_CREATION_DATE = "10:00AM OCT. 7th 2047";

    public static final String AVATAR_URL = "https://avatars2.githubusercontent.com/u/12968428?v=4";

    public static final String ERROR_MESSAGE = "An error has occured.";



    public static final RepositoryListItem REPOSITORY_LIST_ITEM =
            new RepositoryListItem(REPO_DESCRIPTION,
                    REPO_CREATION_DATE,
                    AVATAR_URL);

    public static final ListViewModel LIST_VIEW_MODEL_SUCCESS = ListViewModel.success(getTestList());

    public static final ListViewModel LIST_VIEW_MODEL_FAILURE = ListViewModel.error(ERROR_MESSAGE);

    public static final ListViewModel LIST_VIEW_MODEL_LOADING = ListViewModel.loading();



    public static List<RepositoryListItem> getTestList(){
        List<RepositoryListItem> testList = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            testList.add(new RepositoryListItem(
                    REPO_DESCRIPTION,
                    REPO_CREATION_DATE,
                    AVATAR_URL
            ));
        }

        return testList;
    }

}
