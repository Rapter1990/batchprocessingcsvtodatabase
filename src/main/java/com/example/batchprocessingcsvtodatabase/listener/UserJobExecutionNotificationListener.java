package com.example.batchprocessingcsvtodatabase.listener;

import com.example.batchprocessingcsvtodatabase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

@Slf4j
@RequiredArgsConstructor
public class UserJobExecutionNotificationListener extends JobExecutionListenerSupport {

    private final UserRepository userRepository;

    @Override
    public void beforeJob(JobExecution jobExecution){
        log.info("UserJobExecutionNotificationListener | beforeJob | Executing job id : " +jobExecution.getJobId());
        super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution){

        log.info("UserJobExecutionNotificationListener | afterJob | Executing job id : " +jobExecution.getJobId());

        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Job Completed");
        }
        userRepository.findAll()
                .forEach(person -> log.info("Found (" + person + ">) in the database.") );
    }
}
