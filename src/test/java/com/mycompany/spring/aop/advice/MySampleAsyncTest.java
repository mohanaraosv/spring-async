package com.mycompany.spring.aop.advice;

import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycompany.spring.async.sample.MySampleAsyncService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleAsyncConfiguration.class)
public class MySampleAsyncTest {

    @Autowired
    private MySampleAsyncService mySampleAsyncService;

    @Test
    public void testNormalExection() throws InterruptedException {
        String totalTime = mySampleAsyncService.normalExecutor();
        System.out.println("Total time taken : " + totalTime);
    }

    @Test
    public void testAsyncExection() throws InterruptedException, ExecutionException {
        String totalTime = mySampleAsyncService.taskExecutor();
        System.out.println("Total time taken : " + totalTime);
    }
}
