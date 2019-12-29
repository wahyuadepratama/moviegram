package site.wahyu.moviegram.utils;

import java.util.concurrent.Executor;

import site.wahyu.moviegram.utils.helper.AppExecutors;

public class InstantAppExecutors extends AppExecutors {
    private static Executor instant = Runnable::run;

    public InstantAppExecutors() {
        super(instant, instant, instant);
    }
}
