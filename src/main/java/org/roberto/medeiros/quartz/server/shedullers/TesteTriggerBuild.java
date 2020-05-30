package org.roberto.medeiros.quartz.server.shedullers;

import org.quartz.*;
import org.roberto.medeiros.quartz.server.shedullers.TesteJob;
import org.roberto.medeiros.quartz.server.utils.ParametrosBaseH2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class TesteTriggerBuild {

    @Bean
    public JobDetail jobDetail() {
        JobDetail job = JobBuilder.newJob(TesteJob.class)
                .withIdentity("testeJOB", "grupo01")
                .storeDurably()
                .build();

        return job;
    }

    @Bean
    public Trigger trigger(JobDetail job) {

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("testeTRIGGER","grupo01")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * *"))
                .forJob(jobDetail())
                .build();

        return trigger;
    }

}
