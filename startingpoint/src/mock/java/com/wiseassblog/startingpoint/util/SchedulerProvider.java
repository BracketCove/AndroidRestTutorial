package com.wiseassblog.startingpoint.util;

import com.wiseassblog.startingpoint.util.BaseSchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * For use during Tests which require Mock Schedulers.
 * Created by R_KAY on 11/21/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {
    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler getComputerScheduler() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler getUiScheduler() {
        return Schedulers.trampoline();
    }
}
