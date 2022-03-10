package com.daneking.stockquote.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
@Slf4j
public class Scheduler {
    private final TaskScheduler taskScheduler;
    private final QuoteTask task;
    private ScheduledFuture<?> taskState;

    public Scheduler(TaskScheduler taskScheduler,
                     QuoteTask task) {
        this.taskScheduler = taskScheduler;
        this.task = task;
    }

    public void run() {
        //check calendar if not holiday start polling
        log.info("Running task.....");
        taskState = taskScheduler.schedule(task, new CronTrigger("0 */15 9-16 * * 1-5"));
    }

    public void stop() {
        log.info("Stopping task.....");
        taskState.cancel(false);
    }

}
