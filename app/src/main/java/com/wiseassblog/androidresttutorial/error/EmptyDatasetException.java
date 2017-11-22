package com.wiseassblog.androidresttutorial.error;

import java.io.IOException;

/**
 * Created by R_KAY on 11/21/2017.
 */

public class EmptyDatasetException extends IOException {

    private final String message;

    public EmptyDatasetException(){
        this.message = "No Repos listed for given Username";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
