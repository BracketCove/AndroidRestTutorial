package com.wiseassblog.androidresttutorial.util;

import io.reactivex.Scheduler;

/**
 * Created by R_KAY on 11/21/2017.
 */

public interface BaseSchedulerProvider {

    Scheduler getIOScheduler();

    Scheduler getComputerScheduler();

    Scheduler getUiScheduler();
}
