package com.wiseassblog.androidresttutorial.viewmodel;

import java.util.List;

/**
 * ViewModel for ListActivity.
 *
 * Capable of representing multiple different states of the View, including certain error states
 * which shouldn't actually be handled on onError()
 *
 * See Dan Lew's awesome blog about this here:
 * http://blog.danlew.net/2015/12/08/error-handling-in-rxjava/
 *
 * And Jake Wharton's awesome talk about Rx and Application State here:
 * https://www.youtube.com/watch?v=0IKHxjkgop4
 *
 * Created by R_KAY on 11/18/2017.
 */

public final class ListViewModel {
    final boolean hasError;
    final boolean isLoading;
    final String errorMessage;
    private List<RepositoryListItem> repoList;

    private ListViewModel(boolean hasError,
                          boolean isLoading,
                          String errorMessage,
                          List<RepositoryListItem> repoList) {
        this.hasError = hasError;
        this.isLoading = isLoading;
        this.errorMessage = errorMessage;
        this.repoList = repoList;
    }

    public boolean hasError() {
        return hasError;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<RepositoryListItem> getRepoList() {
        return repoList;
    }

    public static ListViewModel loading(){
        return new ListViewModel(false, true, null, null);
    }

    public static ListViewModel success(List<RepositoryListItem> repoList){
        return new ListViewModel(false, false, null, repoList);
    }

    public static ListViewModel error(String errorMessage){
        return new ListViewModel(true, false, errorMessage, null);
    }

}
