package com.mycompany.spring.async.sample;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;

/**
 * @author mohanarao_sv
 *
 */
@Component
public class MySampleService {

    private final static Logger LOG = LoggerFactory.getLogger(MySampleService.class);

    @Async
    public Future<Long> callAsync(final int taskCall) throws InterruptedException {
        LOG.info("Current thread name : " + Thread.currentThread().getName());
        Stopwatch stopwatch = Stopwatch.createStarted();
        LOG.info("Task : " + taskCall + " starting");
        Thread.sleep(taskCall);
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        LOG.info("Task :" + taskCall + " completed.");
        return new AsyncResult<Long>(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public Long callDirectly(final int taskCall) throws InterruptedException {
        LOG.info("Current thread name : " + Thread.currentThread().getName());
        Stopwatch stopwatch = Stopwatch.createStarted();
        LOG.info("Task : " + taskCall + " starting");
        Thread.sleep(3000);
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        LOG.info("Task :" + taskCall + " completed.");
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
