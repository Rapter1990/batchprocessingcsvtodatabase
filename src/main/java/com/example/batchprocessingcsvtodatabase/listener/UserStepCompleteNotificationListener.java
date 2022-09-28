package com.example.batchprocessingcsvtodatabase.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

@Slf4j
public class UserStepCompleteNotificationListener extends StepExecutionListenerSupport {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("UserStepCompleteNotificationListener | beforeStep | StepExecution job id : " + stepExecution.getId());
        super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("UserStepCompleteNotificationListener | afterStep | StepExecution job id : " + stepExecution.getId());
        return super.afterStep(stepExecution);
    }

}
