package com.mycompany.spring.async.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author mohanarao_sv
 *
 */
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncExecutor()
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setCorePoolSize(7);
        taskExecutor.setQueueCapacity(11);
        taskExecutor.setThreadNamePrefix("CUSExecutor---");
        taskExecutor.initialize();
        return taskExecutor;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncUncaughtExceptionHandler()
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
