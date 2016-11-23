package com.mycompany.spring.async.sample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Stopwatch;

/**
 * @author mohanarao_sv
 *
 */
@Service
public class MySampleAsyncService {

    private final static Logger LOG = LoggerFactory.getLogger(MySampleAsyncService.class);

    @Autowired
    private MySampleService     mySampleService;

    public String taskExecutor() throws InterruptedException, ExecutionException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Future<Long> result1 = mySampleService.callAsync(3000);
        Future<Long> result2 = mySampleService.callAsync(4000);
        Future<Long> result3 = mySampleService.callAsync(5000);
        Future<Long> result4 = mySampleService.callAsync(7000);

        LOG.info("Result 1 took : " + result1.get());
        LOG.info("Result 2 took : " + result2.get());
        LOG.info("Result 3 took : " + result3.get());
        LOG.info("Result 4 took : " + result4.get());

        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        return "Time it took to perform work " + stopwatch;
    }

    public String normalExecutor() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Long asyncResult1 = mySampleService.callDirectly(1);
        Long asyncResult2 = mySampleService.callDirectly(2);
        Long asyncResult3 = mySampleService.callDirectly(3);
        Long asyncResult4 = mySampleService.callDirectly(4);

        LOG.info("Result 1 took : " + asyncResult1);
        LOG.info("Result 2 took : " + asyncResult2);
        LOG.info("Result 3 took : " + asyncResult3);
        LOG.info("Result 4 took : " + asyncResult4);

        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        return "Time it took to perform work " + stopwatch;
    }
}
